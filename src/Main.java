import commandandtag.AvailableTags;
import commandandtag.Command;
import commandandtag.CommandAndTag;
import commandandtag.Tag;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {
        String data = "21\n" +
                "create\n" +
                "create\n" +
                "create\n" +
                "create\n" +
                "execute 11\n" +
                "create\n" +
                "create\n" +
                "create\n" +
                "create\n" +
                "create\n" +
                "create\n" +
                "execute 2\n" +
                "create\n" +
                "execute 2\n" +
                "execute 11\n" +
                "execute 2\n" +
                "execute 5\n" +
                "execute 5\n" +
                "execute 2\n" +
                "execute 5\n" +
                "execute 5";
        byte[] bytes = data.getBytes(StandardCharsets.UTF_8);

        try(InputStream inputStream = new ByteArrayInputStream(bytes);
            InputStream bufferedInputStream = new BufferedInputStream(inputStream, 8192);
            InputStreamReader inputStreamReader = new InputStreamReader(bufferedInputStream, StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(inputStreamReader, 8192);
        ){
            int count = Integer.parseInt(br.readLine());
            while(true){
                String input = br.readLine();
                if(input == null){
                    break;
                }
                String[] inputArray = input.split(" ");
                Command command = Command.from(inputArray[0]);
                Tag tag = null;
                if(inputArray.length == 2){
                    tag = Tag.from(inputArray[1]);
                }
                CommandAndTag commandAndTag = new CommandAndTag(command, tag);

                Tag doneTag = AvailableTags.execute(commandAndTag);





            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}