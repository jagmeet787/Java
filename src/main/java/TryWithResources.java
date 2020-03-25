import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TryWithResources {
    public static void main(String[] args) {
        InputStream in;
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println(br.readLine());
            throw new Exception("message");
        } catch (IOException ie) {
            System.out.println(ie);
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("End");
    }
}
