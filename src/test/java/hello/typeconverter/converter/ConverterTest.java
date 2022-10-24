package hello.typeconverter.converter;

import hello.typeconverter.type.IpPort;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ConverterTest {


    @Test
    void stringToInteger(){
        StringToIntegerConverter converter = new StringToIntegerConverter();

        Integer result = converter.convert("10");

        assertThat(result).isEqualTo(10);
    }

    @Test
    void integerToString(){
        IntegerToStringConverter converter = new IntegerToStringConverter();

        String result = converter.convert(10);

        assertThat(result).isEqualTo("10");
    }

    @Test
    void stringToIpPort(){

        IpPort source = new IpPort("127.0.0.1", 8080);

        IpPortToStringConverter converter = new IpPortToStringConverter();

        String result = converter.convert(source);

        assertThat(result).isEqualTo("127.0.0.1:8080");
    }

    @Test
    void ipPortToString(){
        String source ="127.0.0.1:8080";

        StringToIpPortConverter converter = new StringToIpPortConverter();

        IpPort result = converter.convert(source);

        assertThat(result).isEqualTo(new IpPort("127.0.0.1", 8080));

    }

}
