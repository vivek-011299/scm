package com.scm.helpers;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    private String content;
    private MessageType msgType = MessageType.blue;
}
