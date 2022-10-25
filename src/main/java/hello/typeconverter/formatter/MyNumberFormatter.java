package hello.typeconverter.formatter;


import lombok.extern.slf4j.Slf4j;
import org.springframework.format.Formatter;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

@Slf4j //                          Integer,Long 등을 다 포함하는 부모 클래스
public class MyNumberFormatter implements Formatter<Number> {
    @Override
    public Number parse(String text, Locale locale) throws ParseException {
        log.info("text = {}, locale = {}",text, locale);
        // "1,000" -> 1000
        // 포맷 지정용 넘버포멧 객체 생성
        NumberFormat format = NumberFormat.getInstance(locale);
        return format.parse(text);
    }

    @Override
    public String print(Number object, Locale locale) {
        log.info("object={}, locale={}",object,locale);
        NumberFormat instance = NumberFormat.getInstance(locale);
        return instance.format(object);

    }
}
