package cz.cvut.fel.rsp.tripguide.service;

import cz.cvut.fel.rsp.tripguide.dto.ContactUsDto;

public interface MailService {
    void sendEmail(ContactUsDto mail);
}
