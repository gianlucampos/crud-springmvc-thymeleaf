package br.com.crudGenerico.common.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import lombok.experimental.UtilityClass;

@UtilityClass
public class FormatterUtils {

    private final Locale PT_BR = Locale.forLanguageTag("pt-BR");

    public String parseCurrencyBRL(Number value) {
        DecimalFormat df = new DecimalFormat("#,##0.00", DecimalFormatSymbols.getInstance(PT_BR));
        return df.format(value);
    }

    public BigDecimal parseCurrencyBRL(String amount) {
        try {
            NumberFormat format = NumberFormat.getNumberInstance(PT_BR);
            if (format instanceof DecimalFormat) {
                ((DecimalFormat) format).setParseBigDecimal(true);
            }
            return (BigDecimal) format.parse(amount.replaceAll("[^\\d.,]", ""));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

}
