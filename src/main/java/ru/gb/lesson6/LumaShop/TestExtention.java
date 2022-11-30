package ru.gb.lesson6.LumaShop;

import io.qameta.allure.Allure;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.io.ByteArrayInputStream;

public class TestExtention implements TestWatcher {
    ByteArrayInputStream screenStream;

    public void setScreenStream(ByteArrayInputStream screenStream) {
        this.screenStream = screenStream;
    }

    public void testFailed(ExtensionContext context, Throwable cause) {
        Allure.addAttachment("Скриншот перед закрытием браузера", screenStream);
        System.out.println("ТСТ УПАЛ");
    }




}
