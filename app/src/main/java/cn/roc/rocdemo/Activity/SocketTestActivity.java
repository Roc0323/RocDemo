package cn.roc.rocdemo.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import cn.roc.rocdemo.R;

public class SocketTestActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btn_tcp_connect;
    private Button btn_tcp_send_message;
    private Button btn_udp_send;
    private Button btn_udp_receive;
    private TextView tv_socket_test1;
    private TextView tv_socket_test2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_socket_test);
        initView();
    }
    private void initView(){
        btn_tcp_connect=(Button)findViewById(R.id.btn_tcp_connect);
        btn_tcp_connect.setOnClickListener(this);
        btn_tcp_send_message=(Button)findViewById(R.id.btn_tcp_send_message);
        btn_tcp_send_message.setOnClickListener(this);
        btn_udp_send=(Button)findViewById(R.id.btn_udp_send);
        btn_udp_send.setOnClickListener(this);
        btn_udp_receive=(Button)findViewById(R.id.btn_udp_receive);
        btn_udp_receive.setOnClickListener(this);
        tv_socket_test1=(TextView)findViewById(R.id.tv_socket_test1);
        tv_socket_test2=(TextView)findViewById(R.id.tv_socket_test2);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_tcp_connect:
                initTcpConnect();
                break;
            case R.id.btn_tcp_send_message:
                break;
            case R.id.btn_udp_send:
                udpSend();
                break;
            case R.id.btn_udp_receive:
                udpReceive();
                break;
        }
    }
    //初始化Tcp连接
    private void initTcpConnect(){
        final String host = "192.168.3.147"; // 要连接的服务端IP地址
        final int port = 5583; // 要连接的服务端对应的监听端口
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Log.i("TAG","代码是否执行");
                    // 与服务端建立连接
                    Socket client = new Socket(host, port);
                    InputStream inputStream = client.getInputStream();
                    InputStreamReader reader = new InputStreamReader(inputStream);
                    BufferedReader bufferedReader = new BufferedReader(reader);
                    String message = bufferedReader.readLine();
                    System.out.println(message);
                    bufferedReader.close();
                    client.close();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
    //UdpSend
    private void udpSend(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                MulticastSocket socket;
                try {
                    socket = new MulticastSocket(8842);
                    socket.setTimeToLive(1);
                    InetAddress address = InetAddress.getByName("233.0.0.0");
                    socket.joinGroup(address);
                    byte[] buf = "hello world!".getBytes();
                    DatagramPacket p = new DatagramPacket(buf, buf.length, address, 8842);
                    socket.send(p);
                    System.out.println("广播已经发出");
                    Log.i("TAG","广播已经发出");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    //UdpReceive
    private void udpReceive(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                MulticastSocket socket;
                try {
                    socket = new MulticastSocket(8842);
                    socket.setTimeToLive(1);
                    InetAddress address = InetAddress.getByName("233.0.0.0");
                    socket.joinGroup(address);
                    byte[] buf = new byte[3000];
                    DatagramPacket p = new DatagramPacket(buf, buf.length);
                    socket.receive(p);
                    System.out.println("接受到" + p.getAddress() + "的广播消息" + new String(p.getData()));
                    Log.i("TAG","接受到" + p.getAddress() + "的广播消息" + new String(p.getData()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }





    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
