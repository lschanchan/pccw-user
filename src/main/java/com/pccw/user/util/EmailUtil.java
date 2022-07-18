package com.pccw.user.util;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EmailUtil {
    public static void sendEmail(String email) {
        log.info("welcome email to " + email);
    }
}
