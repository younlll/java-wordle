package util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import model.Characters;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AnswerGroupProviderTest {

    @Test
    @DisplayName("words.txt파일에서 제공된 단어 전체를 불러왔는지 확인")
    void provide() {
        List<Characters> provide = AnswerGroupProvider.provide();

        assertThat(provide.size()).isEqualTo(2309);
    }
}