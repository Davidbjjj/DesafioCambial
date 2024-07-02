package org.example.src.model;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conversor {
    private String moeda;

    public String getMoeda() {
        return moeda;
    }

    public void setMoeda(String moeda) {
        this.moeda = moeda;
    }

    public String ConversorMoeda() throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/bcf66faadad8704e370fc32a/latest/" + getMoeda()))
                .build();
        try {
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (Exception e) {
            throw new RuntimeException("Não consegui encontrar moeda.");
        }
    }
    public String extrairTaxaDeConversao(String responseBody, String currency) {
        JsonObject jsonObject = JsonParser.parseString(responseBody).getAsJsonObject();
        if (!jsonObject.has("conversion_rates")) {
            throw new RuntimeException("Campo conversion_rates não encontrado na resposta da API.");
        }

        JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");
        if (!conversionRates.has(currency)) {
            throw new RuntimeException("Moeda " + currency + " não encontrada nas taxas de conversão.");
        }

        return conversionRates.get(currency).getAsString();
    }
    public float valorDesejado(float valor, String converte) throws IOException, InterruptedException {
        float convetido=Float.parseFloat(extrairTaxaDeConversao(ConversorMoeda(),converte));
        float valorTotal=valor*convetido;
        return valorTotal;
    }
}
