package com.github.jonasermert

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;

/**
 * @author Jonas Ermert
 * @version 1.0.0
 * @since 1.0.0
 */

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
        sendInvitation();
        createServer();

        System.out.println("You can invite the bot by using the following url: " + api.createBotInvite());
    }

    public createChannel() {
        ServerVoiceChannel channel = new ServerVoiceChannelBuilder(server)
                .setName("jonas-channel")
                .setUserlimit(10)
                .create().join();
    }

    public sendInvitation(){
        Invite invite = new InviteBuilder(channel)
                .setMaxAgeInSeconds(60*60*24)
                .setMaxUses(42)
                .create().join();
    }

    public createServer(){
        long serverId = new ServerBuilder(api)
                .setName("Jonas Server")
                .setIcon(api.getYourself().getAvatar())
                .setVerificationLevel(VerificationLevel.HIGH)
                .setDefaultMessageNotificationLevel(DefaultMessageNotificationLevel.ONLY_MENTIONS)
                .setRegion(Region.EU_CENTRAL)
                .create().join();
    }


}

