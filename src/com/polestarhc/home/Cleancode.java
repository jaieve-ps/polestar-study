//package com.polestarhc.home;
//
//import java.util.regex.Pattern;
//
//public class BoldWidget extends ParantWidget {
//    public static final String REGEXP = "'''.+?'''";
//    private static final Pattern pattern = Pattern.compile("'''(.?)'''",
//            Pattern.MULTILINE + Pattern.DOTALL
//    );
//
//    public Boldwidget(ParentWidget parent, String text) throws Exceptionx {
//        super(parent);
//        Matcher match = pattern.matcher(text);
//        match.find();
//        addchildWidgets(match.group(1));
//    }
//    public Strign render() throws Exception {
//        StrignBuffer html = new StringBuffer("<b>");
//        html.append(childHtml)
//    }
//
//}
