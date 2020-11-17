import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        String sourceText = "A Elbereth Gilthoniel silivren penna miriel o menel aglar elenath!" +
                "Na-chaered palan-diriel o galadhremmin ennorath, fanuilos le linnathon nef aear, " +
                "si nef aearon";

        getSortedList(sourceText, getStringAsList()).forEach(System.out::println);
    }

    //Используются детерминированные функции и монады
    public static Function<String, List<String>> getStringAsList() {
        return value -> Stream.of(value.split("\\W+"))
                .distinct().map(String::new)
                .collect(Collectors.toList());
    }

    public static List<String> getSortedList
            (String sourceString, Function<String, List<String>> f) {
        return f.apply(sourceString).stream().sorted().collect(Collectors.toList());
    }
}
