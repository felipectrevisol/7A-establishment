package br.com.sev7aura.establishment.httpresource;

public record DigitalContactHttpBodyPart(boolean isWhatsApp, String phone, String areaCode, String email) {}