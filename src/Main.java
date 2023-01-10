import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
        public static <T> void findMinMax(
                Stream<? extends T> stream,
                Comparator<? super T> order,
                BiConsumer<? super T, ? super T> minMaxConsumer) {

            List<T> items = stream.sorted(order).collect(Collectors.toList());
            if (!items.isEmpty()) {
                minMaxConsumer.accept(items.get(0), items.get(items.size() - 1));

            } else {
                minMaxConsumer.accept(null, null);
            }
        }
        public static int findEvenNumbers(List<Integer> numbersList) {

            return (int) numbersList.stream()
                    .filter(i -> i % 2 == 0)
                    .count();
        }

        public static void main(String[] args) {
            List<Integer> numbersList = Arrays.asList(2, 9, 14, 7, 99, 113, 111, 112);
            System.out.println("Исходный массив чисел:\n" + numbersList);

            Stream<Integer> stream1 = numbersList.stream();
            System.out.println("В этом массиве минимальное и максимальное число:");

            findMinMax(
                    stream1,
                    (x, y) -> x.compareTo(y),
                    (x, y) -> System.out.println("min=" + x + ", max=" + y)
            );

            //Стрим штука "одноразовая", поэтому для запуска следующего метода создадим новый стрим
            Stream<Integer> stream2 = numbersList.stream();
            System.out.println("Количество четных чисел: " + findEvenNumbers(stream2.toList()));
    }}
