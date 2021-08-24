package com.github.jonasermert

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;

public class Bot {

    public static void main(String[] args) {

        String token = "your token";
        DiscordApi api = new DiscordApiBuilder().setToken(token).login().join();

        api.addMessageCreateListener(event -> {
            if (event.getMessageContent().equalsIgnoreCase("!ping")) {
                event.getChannel().sendMessage("Hallo, ich bin Jonas Discord Bot");
            }
        });

        System.out.println("You can invite the bot by using the following url: " + api.createBotInvite());
    }
}





}
