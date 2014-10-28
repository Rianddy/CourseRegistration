/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upittis2739.courseregistration.message;

import java.io.Serializable;

/**
 *
 * @author riand_000
 */
public class MailMessage implements Serializable {

    private static final long serialVersionUID = 1L;

    private String mailContent = "";

    private String toAddress = "";

    private String title = "";

    public MailMessage(String mailContent, String toAddress, String title) {

        this.mailContent = mailContent;

        this.toAddress = toAddress;

        this.title = title;

    }

    public String getMailContent() {
        return mailContent;
    }

    public void setMailContent(String mailContent) {
        this.mailContent = mailContent;
    }

    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return " Message Text = " + getMailContent();
    }
}
