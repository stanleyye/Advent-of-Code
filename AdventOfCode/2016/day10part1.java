import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    public static Map<Integer, Bot> hm;
    public int res = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        try {
            Main m = new Main();
            hm = new HashMap<>();
            BufferedReader br = new BufferedReader (new FileReader("day10input.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                m.chips(line);
            }
            // result is printed out
        } finally {}
    }


    public void chips(String s) {
        String[] instructions = s.split(" ");
        if (instructions[0].equals("value")) {
            // Ex. value 5 goes to bot 189
            int value = Integer.parseInt(instructions[1]);
            int botNum = Integer.parseInt(instructions[5]);
            recursivelyGiveChips(botNum, value);

        } else {
            // Ex. bot 123 gives low to bot 191 and high to bot 162
            // Ex. bot 191 gives low to output 9 and high to bot 192
            int botNum = Integer.parseInt(instructions[1]);
            int lowBot = Integer.parseInt(instructions[6]);
            int highBot = Integer.parseInt(instructions[instructions.length-1]);

            Bot newBot = new Bot();
            if (hm.containsKey(botNum)) {
                newBot = hm.get(botNum);
            }

            if (instructions[5].equals("output")) {
                newBot.setLow(-1);
            } else {
                newBot.setLow(lowBot);
            }

            if (instructions[10].equals("output")) {
                newBot.setHigh(-1);
            } else {
                newBot.setHigh(highBot);
            }

            hm.put(botNum, newBot);

            if (!hm.containsKey(lowBot)) hm.put(lowBot, new Bot());
            if (!hm.containsKey(highBot)) hm.put(highBot, new Bot());
        }
    }

    public void recursivelyGiveChips(int botNum, int val) {
        if (botNum == -1 || res != Integer.MIN_VALUE) return;
        System.out.println(botNum);
        if (!hm.containsKey(botNum)) {
            Bot b = new Bot();
            b.insert(val);
            hm.put(botNum, b);
        } else {
            Bot currentBot = hm.get(botNum);
            if (currentBot.getNumChips() < 1) {
                currentBot.insert(val);

            } else {
                if (currentBot.getNumChips() < 2){
                    currentBot.insert(val);
                }
                // if bot is currently holding 2 chips
                int botToGiveLow = currentBot.getLow();
                int botToGiveHigh = currentBot.getHigh();

                int lowerVal = (currentBot.showChips().get(0) > currentBot.showChips().get(1)) ?
                        currentBot.showChips().get(1) : currentBot.showChips().get(0);
                int higherVal = (currentBot.showChips().get(0) > currentBot.showChips().get(1)) ?
                        currentBot.showChips().get(0) : currentBot.showChips().get(1);

                if (lowerVal == 17 && higherVal == 61) {
                    res = botNum;
                    System.out.println(res);
                    return;
                }

                currentBot.clearChips();

                recursivelyGiveChips(botToGiveLow, lowerVal);
                recursivelyGiveChips(botToGiveHigh, higherVal);

                currentBot.insert(val);

            }
            hm.put(botNum, currentBot);
        }
    }

    public class Bot {
        private List<Integer> microchips;
        private int low = Integer.MIN_VALUE;
        private int high = Integer.MAX_VALUE;

        public Bot() {
            this.microchips = new ArrayList<>();
        }

        public void insert(int i) {
            this.microchips.add(i);
        }

        public List<Integer> showChips() {
            return this.microchips;
        }

        public int getNumChips() {
            return this.microchips.size();
        }

        public void clearChips() {
            this.microchips.clear();
        }

        public void setLow(int sl) {
            this.low = sl;
        }

        public int getLow() {
            return this.low;
        }

        public void setHigh(int sh) {
            this.high = sh;
        }

        public int getHigh() {
            return high;
        }
    }
}




