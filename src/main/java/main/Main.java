package main;

import chat.ChatServer;

import java.io.IOException;

/**
 * @author rassoll
 * @created 20.10.2018
 */
public class Main
{
    public static void main(String[] args) throws IOException
    {
        try
        {
            ChatServer server = new ChatServer(5050);
            server.start();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}