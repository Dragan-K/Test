package org.example;

import com.slack.api.Slack;
import com.slack.api.SlackConfig;
import com.slack.api.methods.response.chat.ChatPostMessageResponse;

import java.io.IOException;

public class SlackSendMessage {

    String token = "";
    String channel = "#bot-test";

    private void sendMessageToChannel(final String message) {
        try {
            SlackConfig config = new SlackConfig();
            config.setPrettyResponseLoggingEnabled(true);
            config.setTokenExistenceVerificationEnabled(true);
            Slack slack = Slack.getInstance(config);
            final ChatPostMessageResponse response = slack
                .methods(token)
                .chatPostMessage(req -> req.channel(channel).text(message));
            if (!response.isOk()) {
                System.out.println("OK!");
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void main(String[] args) {
        SlackSendMessage msg = new SlackSendMessage();
        msg.sendMessageToChannel("Test test");
    }

}
