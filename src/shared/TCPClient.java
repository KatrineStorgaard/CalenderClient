package shared;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;


public class TCPClient {
	
	private Socket clientSocket;
	private DataOutputStream outToServer;
	
	public void connect(String gsonString) {
	
		try {
			Socket clientSocket = new Socket("localhost", 8888);
			DataOutputStream outToServer = new DataOutputStream(
					clientSocket.getOutputStream());
			byte[] input = gsonString.getBytes();
			byte key = (byte) Double.parseDouble("3.1470");
			byte[] encrypted = input;
			for (int i = 0; i < encrypted.length; i++)
				encrypted[i] = (byte) (encrypted[i] ^ key);

			outToServer.write(encrypted);
			outToServer.flush();
			BufferedReader inFromServer = new BufferedReader(new InputStreamReader(
					clientSocket.getInputStream()));
			String modifiedSentence = inFromServer.readLine();
			
			System.out.println("response: " + modifiedSentence);
			clientSocket.close();
		} catch (IOException e){
			e.printStackTrace();
			
		}
		
	}
}