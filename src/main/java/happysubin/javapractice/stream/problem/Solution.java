package stream.problem;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul","Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian,2011,300),
                new Transaction(raoul,2012,1000),
                new Transaction(raoul,2011,400),
                new Transaction(mario,2012,710),
                new Transaction(mario,2012,700),
                new Transaction(alan,2012,950)
        );

        //2011년에 발생한 트랜잭션을 찾아서 정렬해라.
        List<Transaction> list1 = transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getYear))
                .collect(Collectors.toList());
        System.out.println("list1 = " + list1);

        //거래자가 근무하는 도시를 중복 없이 나열
        List<String> list2 = transactions.stream()
                .map(t -> t.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());
        System.out.println("list = " + list2);

        //케임브리지에서 근무하는 모든 거래자를 찾아서 이름 순으로 정렬
        List<Trader> cambridge = transactions.stream()
                .map(t -> t.getTrader())
                .filter(h -> h.getCity().equals("Cambridge"))
                .distinct()
                .sorted(Comparator.comparing(t->t.getName()))
                .collect(Collectors.toList());
        System.out.println("cambridge = " + cambridge);

        //모든 거래자의 이름을 알파벳 순으로 정렬
        List<String> member = transactions.stream()
                .map(t -> t.getTrader().getName())
                .sorted()
                .distinct()
                .collect(Collectors.toList());

        System.out.println("member = " + member);

        //밀라노에 거래자가 있는가?
        List<Trader> milan = transactions.stream()
                .map(t -> t.getTrader())
                .filter(t -> t.getCity().equals("Milan"))
                .distinct()
                .collect(Collectors.toList());
        boolean milan1 = transactions.stream()
                .anyMatch(t -> t.getTrader().getCity().equals("Milan"));
        System.out.println("milan = " + milan);
        System.out.println("milan1 = " + milan1);

        //케임브리지에 거주하는 거래자의 모든 트랜잭션 값을 출력
        transactions.stream()
                .filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .map(t -> t.getValue())
                .forEach(t -> System.out.println(t));

        //전체 트랜잭션 중 최대 값

        Optional<Integer> reduce = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max);
        System.out.println("reduce = " + reduce.get());


        //전체 트랜잭션 중 최소 값
        transactions.stream()
                .map(t->t.getValue())
                .sorted()
                .limit(1)
                .forEach(System.out::println);
    }
}
