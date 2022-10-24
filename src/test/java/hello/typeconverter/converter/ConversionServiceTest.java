package hello.typeconverter.converter;

import hello.typeconverter.type.IpPort;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.core.convert.support.DefaultConversionService;

import static org.assertj.core.api.Assertions.*;

public class ConversionServiceTest {

    @Test
    void conversionService(){

        // 등록
        DefaultConversionService conversionService = new DefaultConversionService();
        conversionService.addConverter(new StringToIntegerConverter());
        conversionService.addConverter(new IntegerToStringConverter());
        conversionService.addConverter(new IpPortToStringConverter());
        conversionService.addConverter(new StringToIpPortConverter());

        // 사용
//        Integer result = conversionService.convert("10", Integer.class);
//        System.out.println("result = " + result);
        //  파라미터의 타입을 보고 쓸 컨버터를 찾는다.
        // 사용자 입장에서는 conversionService 인터페이스만 알면 된다.
        // 물론 빈 주입은 받아야한다.
        // 그냥 파라미터랑 원하는 타입만 넣으면 된다.

        assertThat(conversionService.convert("10", Integer.class))
                .isEqualTo(10);
        assertThat(conversionService.convert(10, String.class))
                .isEqualTo("10");

        IpPort ipPort = conversionService.convert("127.0.0.1:8080", IpPort.class);
        assertThat(ipPort)
                .isEqualTo(new IpPort("127.0.0.1",8080));

        String ipPortString = conversionService.convert(new IpPort("127.0.0.1", 8080), String.class);
        assertThat(ipPortString).isEqualTo("127.0.0.1:8080");
    }
}
