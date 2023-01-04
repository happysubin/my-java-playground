package happysubin.javapractice.project.lotto.src.view;

import happysubin.javapractice.project.lotto.src.model.Lotto;
import happysubin.javapractice.project.lotto.src.model.Prize;

import java.util.*;
import java.util.stream.Collectors;

public class OutputView {

    public static void printLottoList(List<Lotto> lotto){
        System.out.println(lotto.size() + "개를 구매했습니다.");
        for (Lotto l : lotto) {
            System.out.println(l.getNumbers());
        }
    }

    public static void printPrizes(List<Prize> prizes) {
        System.out.println("당첨 통계");
        System.out.println("---");
        Map<Prize, Integer> map = getPrizeCountMap(prizes);
        printMap(map);
    }

    private static Map<Prize, Integer> getPrizeCountMap(List<Prize> prizes) {
        Map<Prize, Integer> map = new LinkedHashMap<>();
        Arrays.stream(Prize.values()).forEach(p -> map.put(p, 0));
        prizes.forEach(p -> map.put(p, map.getOrDefault(p, 0)+ 1));
        return map;
    }

    private static void printMap(Map<Prize, Integer> map) {
        map.entrySet().forEach(entry -> {
            if(entry.getKey() != Prize.FAIL){
                System.out.println(entry.getKey().toString() + " - " + entry.getValue() + "개");
            }
        });
    }

    public static void printRateOfReturn(double calculateRateOfReturn) {
        System.out.println("총 수익률은 "+ calculateRateOfReturn +"%입니다.");
    }
}
