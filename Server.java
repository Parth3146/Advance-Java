import java.io.*;
import java.net.*;

public class Server
{
	public static void main(String[] args)
	{
		try
		{
			String str,str1;
			ServerSocket ss = new ServerSocket(7777);
			Socket s = ss.accept();
			System.out.println("Connection established !!");
			OutputStream op = s.getOutputStream();
			PrintStream ps = new PrintStream(op);
////////////////////////////////////////////////////////////////
			InputStream inp = s.getInputStream();
BufferedReader br = new BufferedReader(new InputStreamReader(inp));
			BufferedReader kb = new BufferedReader(new InputStreamReader(System.in));
			while((str1 = br.readLine()) != null)
			{
				System.out.print("Client: "+str1+"\n");
				str = kb.readLine();
				ps.println(str);
			}
			System.out.print("Client: Bye");
			ps.close();
			br.close();
			kb.close();
			ss.close();
			s.close();
			System.exit(0);
		}
		catch(Exception e){System.out.println(e);}
	}
}