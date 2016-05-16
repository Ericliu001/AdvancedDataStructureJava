package com.ericliu.developer.interview;

import org.junit.Test;

import java.util.List;

/**
 * Created by ericliu on 15/05/2016.
 * <p/>
 * <p/>
 * AddThis Sharing Buttons
 * Remove particular combination of characters from string.
 * Given a string, we need to remove a particular combination of characters, for example,
 * if s = “aacbbdccaac” and if combination is “ac” then our output will be “abbdcca”.
 * if s = “aacaaccd” and if combination is “ac”, then output should be “acd”.
 * Following will be the execution
 * aacaaccd ——-> aacd ——>ad
 * Note that this has to be done in linear time and without any extra space.
 *
 * @see <a href="algorithm and me">http://algorithmsandme.in/2013/11/strings-removing-particular-combination-of-characters/</a>
 */
public class String1 {

    String sourceStr = "abcasfdabcisahabcgiabc";
    String patternStr = "abc";
    String outputStr = "";

    public interface Parser {
        boolean process(Context context);
    }


    interface Context {
        char[] source();

        char[] pattern();

        int getStartIndex();

        void setStartIndex(int startIndex);

        StateParser getState();

        void setState(StateParser state);

        void output(char x);

        List<Character> getOutputList();
    }

    public enum StateParser implements Parser {
        MOVING {
            @Override
            public boolean process(Context context) {
                char[] source = context.source();
                char[] pattern = context.pattern();
                int start = context.getStartIndex();
                if (start == source.length) {
                    return false;
                } else if (source[start] == pattern[0]) {
                    context.setState(COMPARING);
                    return true;
                }

                context.output(source[start]);
                context.setStartIndex(++start);
                return true;
            }
        },
        COMPARING {
            @Override
            public boolean process(Context context) {
                char[] source = context.source();
                char[] pattern = context.pattern();
                int start = context.getStartIndex();
                if (start == source.length) {
                    return false;
                }

                boolean patternFoundFlag = true;
                for (int i = 0; i <  pattern.length; i++) {
                    if (i + start == source.length) {
                        return false;
                    }

                    if (source[i + start] != pattern[i]) {
                        patternFoundFlag = false;
                    }

                }

                if (patternFoundFlag) {
                    context.setStartIndex(start + pattern.length);
                } else {
                    context.output(source[start]);
                    context.setState(MOVING);
                    context.setStartIndex(++start);
                }


                return true;
            }
        };


    }

    private void process(Context context) {
        while (context.getState().process(context)) ;
    }

    @Test
    public void testRemovePattern() {
        final char[] source = sourceStr.toCharArray();
        final char[] pattern = patternStr.toCharArray();

        Context context = new Context() {
            private int mStartIndex = 0;
            private StateParser mState = StateParser.MOVING;
            public List<Character> outputList = new java.util.ArrayList<>();


            @Override
            public char[] source() {
                return source;
            }

            @Override
            public char[] pattern() {
                return pattern;
            }

            @Override
            public int getStartIndex() {
                return mStartIndex;
            }

            @Override
            public void setStartIndex(int startIndex) {
                mStartIndex = startIndex;
            }

            @Override
            public StateParser getState() {
                return mState;
            }

            @Override
            public void setState(StateParser state) {
                mState = state;
            }

            @Override
            public void output(char x) {
                outputList.add(x);
            }

            @Override
            public List<Character> getOutputList() {
                return outputList;
            }
        };

        process(context);

        System.out.print(context.getOutputList());

    }

}
