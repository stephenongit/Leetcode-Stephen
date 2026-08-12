// Last updated: 12/08/2026, 19:10:14
class Solution {

    private int index = 0;

    public String countOfAtoms(String formula) {
        Map<String, Integer> map = parse(formula);

        StringBuilder sb = new StringBuilder();

        for (String atom : map.keySet()) {
            sb.append(atom);
            int count = map.get(atom);
            if (count > 1)
                sb.append(count);
        }

        return sb.toString();
    }

    private Map<String, Integer> parse(String formula) {
        Map<String, Integer> map = new TreeMap<>();

        while (index < formula.length() && formula.charAt(index) != ')') {

            if (formula.charAt(index) == '(') {
                index++;
                Map<String, Integer> temp = parse(formula);
                index++;

                int multiplier = readNumber(formula);

                for (String key : temp.keySet()) {
                    map.put(key,
                        map.getOrDefault(key, 0)
                        + temp.get(key) * multiplier);
                }

            } else {

                String atom = readAtom(formula);
                int count = readNumber(formula);

                map.put(atom,
                    map.getOrDefault(atom, 0) + count);
            }
        }

        return map;
    }

    private String readAtom(String formula) {
        StringBuilder sb = new StringBuilder();

        sb.append(formula.charAt(index++));

        while (index < formula.length()
                && Character.isLowerCase(formula.charAt(index))) {
            sb.append(formula.charAt(index++));
        }

        return sb.toString();
    }

    private int readNumber(String formula) {
        if (index >= formula.length()
                || !Character.isDigit(formula.charAt(index)))
            return 1;

        int num = 0;

        while (index < formula.length()
                && Character.isDigit(formula.charAt(index))) {
            num = num * 10 + (formula.charAt(index++) - '0');
        }

        return num;
    }
}