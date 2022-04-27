package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Characters {

    private static final int WORD_LENGTH = 5;

    private final List<Character> characterList;

    public Characters(String inputString) {
        validate(inputString);
        List<Character> characterList = new ArrayList<>();
        String[] split = inputString.split("");
        for (int i = 0; i < WORD_LENGTH; i++) {
            characterList.add(new Character(split[i], i));
        }
        this.characterList = characterList;
    }

    public List<Character> getCharacters() {
        return characterList;
    }

    private void validate(String value) {
        if (value.length() != WORD_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public List<Result> match(Characters answer) {
        Result[] r = new Result[5];
        Arrays.fill(r, Result.NON_EXIST);

        for(int i = 0; i < 5; i++) {
            inputMatchAnswer(characterList.get(i), answer, r);
        }

        for(int i = 0; i < 5; i++) {
            inputMatchAnswer2(characterList.get(i), answer, r);
        }

        return List.of(r);
    }

    private void inputMatchAnswer(Character input, Characters answer, Result[] r) {
        for(int i = 0; i < 5; i++) {
            if (r[input.getPosition()] == Result.NON_EXIST && input.isSame(answer.characterList.get(i)) == Result.MATCH) {
                r[input.getPosition()] = Result.MATCH;
                return;
            }
        }
    }

    private void inputMatchAnswer2(Character input, Characters answer, Result[] r) {
        for(int i = 0; i < 5; i++) {
            if (r[input.getPosition()] == Result.NON_EXIST && r[i] == Result.NON_EXIST && input.isSame(answer.characterList.get(i)) == Result.EXIST) {
                r[input.getPosition()] = Result.EXIST;
            }
        }
    }
}
