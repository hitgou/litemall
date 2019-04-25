package org.linlinjava.litemall.qwfb.util;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.ModelAttribute;

public class LocalDateTimeVM {

    @ModelAttribute
    LocalDate initLocalDate() {
        return LocalDate.now();
    }

}
