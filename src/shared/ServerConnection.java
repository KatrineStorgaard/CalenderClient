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

		try {
			clientSocket = new Socket("localhost", 8888);
			outToServer = new DataOutputStream(
					clientSocket.getOutputStream());
			byte[] encrypted = Encryption(gsonString);

			outToServer.write(encrypted);
			outToServer.flush();

			BufferedReader inFromServer;
				inFromServer = new BufferedReader(new InputStreamReader(
						clientSocket.getInputStream()));
				String modifiedSentence = inFromServer.readLine();
				//System.out.println("response: " + modifiedSentence);

				String answer = crypt(modifiedSentence.getBytes());
				clientSocket.close();
				return answer;

			} catch (IOException e){
				e.printStackTrace();			
			}
				
			return gsonString;
		}
		

		public byte[] Encryption(String gsonString){

			byte[] input = gsonString.getBytes();
			byte key = (byte) 3.1470;
			byte[] encrypted = input;
			for ( int i = 0; i < encrypted.length; i++)
				encrypted[i] = (byte) (encrypted[i]^key);

			return encrypted;

		}

		public String crypt(byte[] b)
		{
			String  crypKey = "3.1470";
			double keyAsDouble = Double.parseDouble(crypKey);
			byte ff = (byte) keyAsDouble;
			for (int i = 0 ; i<b.length ; i++){
				b[i] = (byte)(b[i]^ff);
			}

			String encrypted = new String(b).trim();
			System.out.println(encrypted);
			return encrypted;
		}	

	}	
