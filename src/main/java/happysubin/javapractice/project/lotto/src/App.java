package happysubin.javapractice.project.lotto.src;

import happysubin.javapractice.project.lotto.src.controller.LottoService;

public class App {
    public static void main(String[] args) {
        LottoService lottoService = new LottoService();
        lottoService.start();
    }
}
