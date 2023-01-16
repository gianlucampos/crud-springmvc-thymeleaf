package br.com.crudGenerico.common.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class FormatterUtilsTest {

    @Test
    void formatStringToBigDecimal() {
        String amount = "R$ 200,00";
        BigDecimal excepted = BigDecimal.valueOf(200.00).setScale(2, RoundingMode.UNNECESSARY);

        BigDecimal result = FormatterUtils.parseCurrencyBRL(amount);

        Assertions.assertEquals(excepted, result);
    }

}