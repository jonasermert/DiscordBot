package com.github.jonasermert

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;

public class Bot {

    public static void main(String[] args) {

        String token = "your token";
        DiscordApi api = new DiscordApiBuilder().setToken(token).login().join();

        api.addMessageCreateListener(event -> {
            if (event.getMessageContent().equalsIgnoreCase("!jonas")) {
                event.getChannel().sendMessage("Hallo, ich bin Jonas Discord Bot", MessageDecoration.BOLD);
            }
        });

        createChannel();

        System.out.println("You can invite the bot by using the following url: " + api.createBotInvite());
    }

    public createChannel(Server server) {
        ServerVoiceChannel channel = new ServerVoiceChannelBuilder(server)
                .setName("jonas-channel")
                .setUserlimit(10)
                .create().join();
    }
}

