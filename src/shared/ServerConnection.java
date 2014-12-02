package shared;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;


public class ServerConnection {
	
	private Socket clientSocket;
	private DataOutputStream outToServer;
	
	public String connect(String gsonString) {
		Configurations cf = new Configurations();
		
		try {
			clientSocket = new Socket("localhost", 8888);
			outToServer = new DataOutputStream(
					clientSocket.getOutputStream());
			byte[] input = gsonString.getBytes();
			String plain2 = new String(input).trim();
			byte key = (byte) Double.parseDouble(cf.getFfcryptkey());
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
			return modifiedSentence;
		} catch (IOException e){
			e.printStackTrace();			
		}
		return gsonString;
		
	}
}