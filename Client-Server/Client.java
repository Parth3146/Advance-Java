import java.io.*;
import java.net.*;
import java.util.*;

public class Client
{
	public static void main(String[] args)
	{
		try
		{
			String str,str1;
			Socket s = new Socket("localhost",7777);
			InputStream inp = s.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(inp));
////////////////////////////////////////////////////////////////
			OutputStream op = s.getOutputStream();
			DataOutputStream dos = new DataOutputStream(op);
			BufferedReader kb  = new BufferedReader(new InputStreamReader(System.in));
			while(!(str = kb.readLine()).equals("Bye"))
			{
				dos.writeBytes(str+"\n");
				str1 = br.readLine();
				System.out.println("Server: "+str1);
			}
			System.out.println("Server: Bye");
			dos.close();
			br.close();
			kb.close();
			s.close();
		}
		catch(Exception e){System.out.println(e);}
	}
}
