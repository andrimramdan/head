package org.mifos.test.acceptance.loan;

@SuppressWarnings("PMD")
public class RepaymentScheduleData {

    public static final String[][] EARLY_LESS_FIRST_PAYMENT = {{"Installments paid", "", "", "", "", ""},
            {"1", "19-Oct-2010", "12-Oct-2010", "99.3", "0.7", "0", "0", "0", "100"},
            {"Future Installments", "", "", "", "", ""},
            {"1", "19-Oct-2010", "-", "148.4", "4.2", "100", "0", "0", "252.5"},
            {"2", "26-Oct-2010", "-", "249.5", "3.5", "100", "0", "0", "353"},
            {"3", "02-Nov-2010", "-", "250.7", "2.3", "100", "0", "0", "353"},
            {"4", "09-Nov-2010", "-", "252.1", "1.9", "100", "0",  "0","354"}};
    public static final String[][] EARLY_EXCESS_FIRST_PAYMENT = {{"Installments paid", "", "", "", "", ""},
            {"1", "19-Oct-2010", "12-Oct-2010", "247.7", "0.7", "0", "0", "0", "248.4"},
            {"Future Installments", "", "", "", "", ""},
            {"1", "19-Oct-2010", "-", "0", "3.3", "100", "0", "0", "103.3"},
            {"2", "26-Oct-2010", "-", "217.9", "3.3", "100", "0", "0", "321.2"},
            {"3", "02-Nov-2010", "-", "250.7", "2.3", "100", "0", "0", "353"},
            {"4", "09-Nov-2010", "-", "252.1", "1.9", "100", "0", "0", "354"}};
    public static final String[][] EARLY_WHOLE_FIRST_PAYMENT = {{"Installments paid", "", "", "", "", ""},
        {"1", "19-Oct-2010", "12-Oct-2010", "1,000", "5", "0", "0", "0", "1,005"}
    };
    public static final String[][] LATE_EXCESS_PAYMENT = {{"Installments paid", "", "", "", "", ""},
            {"1", "19-Oct-2010", "23-Oct-2010", "247.7", "5.3", "100", "0", "4", "353"},
            {"2", "26-Oct-2010", "23-Oct-2010", "0", "1", "0", "0", "0", "1"},
            {"Future Installments", "", "", "", "", ""},
            {"2", "26-Oct-2010", "-", "249.5", "3.2", "100", "0", "0", "352.6"},
            {"3", "02-Nov-2010", "-", "250.7", "2.3", "100", "0", "0", "353"},
            {"4", "09-Nov-2010", "-", "252.1", "1.9", "100", "0", "0", "354"}};
    public static final String[][] LATE_EXCESS_SECOND_PAYMENT = {{"Installments paid", "", "", "", "", ""},
            {"1", "19-Oct-2010", "23-Oct-2010", "247.7", "5.3", "100", "0", "4", "353"},
            {"2", "26-Oct-2010", "23-Oct-2010", "0.9", "2.6", "0", "0", "0", "3.5"},
            {"Future Installments", "", "", "", "", ""},
            {"2", "26-Oct-2010", "-", "248.6", "1.5", "100", "0", "0", "350.1"},
            {"3", "02-Nov-2010", "-", "250.7", "2.3", "100", "0", "0", "353"},
            {"4", "09-Nov-2010", "-", "252.1", "1.9", "100", "0", "0", "354"}};
    public static final String[][] LATE_EXCESS_THIRD_PAYMENT = {{"Installments paid", "", "", "", "", ""},
            {"1", "19-Oct-2010", "23-Oct-2010", "247.7", "5.3", "100", "0", "4", "353"},
            {"2", "26-Oct-2010", "23-Oct-2010", "100.9", "2.6", "0", "0", "0", "103.5"},
            {"Future Installments", "", "", "", "", ""},
            {"2", "26-Oct-2010", "-", "148.6", "1.3", "100", "0", "0", "249.9"},
            {"3", "02-Nov-2010", "-", "250.7", "2.3", "100", "0", "0", "353"},
            {"4", "09-Nov-2010", "-", "252.1", "1.9", "100", "0", "0", "354"}};
    public static final String[][] LATE_LESS_FIRST_PAYMENT = {{"Installments paid", "", "", "", "", ""},
            {"1", "19-Oct-2010", "23-Oct-2010", "0", "0", "100", "0", "4", "100"},
            {"Installments due", "", "", "", "", ""},
            {"1", "19-Oct-2010", "", "247.7", "5.3", "0", "0", "4", "253"},
            {"Future Installments", "", "", "", "", ""},
            {"2", "26-Oct-2010", "-", "249.5", "4.2", "100", "0", "0", "353.6"},
            {"3", "02-Nov-2010", "-", "250.7", "2.3", "100", "0", "0", "353"},
            {"4", "09-Nov-2010", "-", "252.1", "1.9", "100", "0", "0", "354"}};
    public static final String[][] LATE_LESS_SECOND_PAYMENT = {{"Installments paid", "", "", "", "", ""},
            {"1", "19-Oct-2010", "23-Oct-2010", "0", "5.3", "100", "0", "4", "105.3"},
            {"Installments due", "", "", "", "", ""},
            {"1", "19-Oct-2010", "", "247.7", "0", "0", "0", "4", "247.7"},
            {"Future Installments", "", "", "", "", ""},
            {"2", "26-Oct-2010", "-", "249.5", "4.2", "100", "0", "0", "353.6"},
            {"3", "02-Nov-2010", "-", "250.7", "2.3", "100", "0", "0", "353"},
            {"4", "09-Nov-2010", "-", "252.1", "1.9", "100", "0", "0", "354"}};
    public static final String[][] LATE_LESS_THIRD_PAYMENT = {{"Installments paid", "", "", "", "", ""},
            {"1", "19-Oct-2010", "23-Oct-2010", "100", "5.3", "100", "0", "4", "205.3"},
            {"Installments due", "", "", "", "", ""},
            {"1", "19-Oct-2010", "", "147.7", "0", "0", "0", "4", "147.7"},
            {"Future Installments", "", "", "", "", ""},
            {"2", "26-Oct-2010", "-", "249.5", "4.2", "100", "0", "0", "353.6"},
            {"3", "02-Nov-2010", "-", "250.7", "2.3", "100", "0", "0", "353"},
            {"4", "09-Nov-2010", "-", "252.1", "1.9", "100", "0", "0", "354"}};
    public static final String[][] MULTIPLE_DUE_FIRST_PAYMENT = {{"Installments paid", "", "", "", "", ""},
            {"1", "19-Oct-2010", "04-Nov-2010", "197.7", "5.3", "100", "0", "16", "303"},
            {"2", "26-Oct-2010", "04-Nov-2010", "0", "0", "100", "0", "9", "100"},
            {"Installments due", "", "", "", "", ""},
            {"2", "26-Oct-2010", "-", "199.3", "5.8", "0", "0", "9", "205.1"},
            {"3", "02-Nov-2010", "-", "200.2", "4", "100", "0", "2", "304.2"},
            {"Future Installments", "", "", "", "", ""},
            {"4", "09-Nov-2010", "-", "201.1", "2.2", "100", "0", "0", "303.3"},
            {"5", "16-Nov-2010", "-", "201.7", "1.3", "100", "0", "0", "303"}};
    public static final String[][] MULTIPLE_DUE_SECOND_PAYMENT = {{"Installments paid", "", "", "", "", ""},
            {"1", "19-Oct-2010", "04-Nov-2010", "197.7", "5.3", "100", "0", "16", "303"},
            {"2", "26-Oct-2010", "06-Nov-2010", "199.3", "5.8", "100", "0", "11", "305.1"},
            {"3", "02-Nov-2010", "06-Nov-2010", "0", "0", "100", "0", "4", "100"},
            {"Installments due", "", "", "", "", ""},
            {"3", "02-Nov-2010", "-", "200.2", "4.2", "0", "0", "4", "204.4"},
            {"Future Installments", "", "", "", "", ""},
            {"4", "09-Nov-2010", "-", "201.1", "2.4", "100", "0", "0", "303.5"},
            {"5", "16-Nov-2010", "-", "201.7", "1.3", "100", "0", "0", "303"}};
    public static String[][] MULTIPLE_DUE_THIRD_PAYMENT = {{"Installments paid", "", "", "", "", ""},
            {"1", "19-Oct-2010", "04-Nov-2010", "197.7", "5.3", "100", "0", "16", "303"},
            {"2", "26-Oct-2010", "06-Nov-2010", "199.3", "5.8", "100", "0", "11", "305.1"},
            {"3", "02-Nov-2010", "09-Nov-2010", "100.2", "4.2", "100", "0", "7", "204.4"},
            {"Installments due", "", "", "", "", ""},
            {"3", "02-Nov-2010", "-", "100", "0", "0", "0", "7", "100"},
            {"4", "09-Nov-2010", "-", "201.1", "2.8", "100", "0", "0", "303.9"},
            {"Future Installments", "", "", "", "", ""},
            {"5", "16-Nov-2010", "-", "201.7", "1.3", "100", "0", "0", "303"}};
    public static final String[][] MULTIPLE_DUE_FORTH_PAYMENT = {{"Installments paid", "", "", "", "", ""},
            {"1", "19-Oct-2010", "04-Nov-2010", "197.7", "5.3", "100", "0", "16", "303"},
            {"2", "26-Oct-2010", "06-Nov-2010", "199.3", "5.8", "100", "0", "11", "305.1"},
            {"3", "02-Nov-2010", "09-Nov-2010", "200.2", "4.2", "100", "0", "7", "304.4"},
            {"4", "09-Nov-2010", "09-Nov-2010", "0", "0", "100", "0", "0", "100"},
            {"Installments due", "", "", "", "", ""},
            {"4", "09-Nov-2010", "-", "201.1", "2.8", "0", "0", "0", "203.9"},
            {"Future Installments", "", "", "", "", ""},
            {"5", "16-Nov-2010", "-", "201.7", "1.3", "100", "0", "0", "303"}};
    public static final String[][] MULTIPLE_DUE_FIFTH_PAYMENT = {{"Installments paid", "", "", "", "", ""},
            {"1", "19-Oct-2010", "04-Nov-2010", "197.7", "5.3", "100", "0", "16", "303"},
            {"2", "26-Oct-2010", "06-Nov-2010", "199.3", "5.8", "100", "0", "11", "305.1"},
            {"3", "02-Nov-2010", "09-Nov-2010", "200.2", "4.2", "100", "0", "7", "304.4"},
            {"4", "09-Nov-2010", "09-Nov-2010", "100", "2.8", "100", "0", "0", "202.8"},
            {"Installments due", "", "", "", "", ""},
            {"4", "09-Nov-2010", "-", "101.1", "0", "0", "0", "0", "101.1"},
            {"Future Installments", "", "", "", "", ""},
            {"5", "16-Nov-2010", "-", "201.7", "1.3", "100", "0", "0", "303"}};
    public static final String[][] MULTIPLE_DUE_SIXTH_PAYMENT = {{"Installments paid", "", "", "", "", ""},
            {"1", "19-Oct-2010", "04-Nov-2010", "197.7", "5.3", "100", "0", "16", "303"},
            {"2", "26-Oct-2010", "06-Nov-2010", "199.3", "5.8", "100", "0", "11", "305.1"},
            {"3", "02-Nov-2010", "09-Nov-2010", "200.2", "4.2", "100", "0", "7", "304.4"},
            {"4", "09-Nov-2010", "15-Nov-2010", "201.1", "2.8", "100", "0", "6", "303.9"},
            {"5", "16-Nov-2010", "15-Nov-2010", "10", "1.2", "0", "0", "0", "11.2"},
            {"Future Installments", "", "", "", "", ""},
            {"5", "16-Nov-2010", "-", "191.7", "0.1", "100", "0", "0", "291.9"}};//291.8 is actual
    public static final String[][] MULTIPLE_DUE_SEVENTH_PAYMENT = {{"Installments paid", "", "", "", "", ""},
            {"1", "19-Oct-2010", "04-Nov-2010", "197.7", "5.3", "100", "0", "16", "303"},
            {"2", "26-Oct-2010", "06-Nov-2010", "199.3", "5.8", "100", "0", "11", "305.1"},
            {"3", "02-Nov-2010", "09-Nov-2010", "200.2", "4.2", "100", "0", "7", "304.4"},
            {"4", "09-Nov-2010", "15-Nov-2010", "201.1", "2.8", "100", "0", "6", "303.9"},
            {"5", "16-Nov-2010", "18-Nov-2010", "201.5", "1.6", "100", "0", "2", "303.1"}};
    public static final String[][] MULTIPLE_DUE_FIRST_ADJUSTMENT = {{"Installments paid", "", "", "", "", ""}, //reversing 291.9 paid on 18-nov
            {"1", "19-Oct-2010", "04-Nov-2010", "197.7", "5.3", "100", "0", "16", "303"},
            {"2", "26-Oct-2010", "06-Nov-2010", "199.3", "5.8", "100", "0", "11", "305.1"},
            {"3", "02-Nov-2010", "09-Nov-2010", "200.2", "4.2", "100", "0", "7", "304.4"},
            {"4", "09-Nov-2010", "15-Nov-2010", "201.1", "2.8", "100", "0", "6", "303.9"},
            {"5", "16-Nov-2010", "15-Nov-2010", "10", "1.2", "0", "0", "0", "11.2"},
            {"Installments due", "", "", "", "", ""},
            {"5", "16-Nov-2010", "-", "191.7", "0.9", "100", "0", "0", "292.6"}};
    public static final String[][] MULTIPLE_DUE_SECOND_ADJUSTMENT = {{"Installments paid", "", "", "", "", ""}, //reversing 112.3 paid on 15-nov
            {"1", "19-Oct-2010", "04-Nov-2010", "197.7", "5.3", "100", "0", "16", "303"},
            {"2", "26-Oct-2010", "06-Nov-2010", "199.3", "5.8", "100", "0", "11", "305.1"},
            {"3", "02-Nov-2010", "09-Nov-2010", "200.2", "4.2", "100", "0", "7", "304.4"},
            {"4", "09-Nov-2010", "09-Nov-2010", "100", "2.8", "100", "0", "0", "202.8"},
            {"Installments due", "", "", "", "", ""},
            {"4", "09-Nov-2010", "-", "101.1", "0", "0", "0", "0", "101.1"},
            {"5", "16-Nov-2010", "-", "201.7", "3.7", "100", "0", "0", "305.4"}}; //1.8,
    public static final String[][] MULTIPLE_DUE_THIRD_ADJUSTMENT = {{"Installments paid", "", "", "", "", ""}, //reversing 102.8 paid on 09-nov
            {"1", "19-Oct-2010", "04-Nov-2010", "197.7", "5.3", "100", "0", "16", "303"},
            {"2", "26-Oct-2010", "06-Nov-2010", "199.3", "5.8", "100", "0", "11", "305.1"},
            {"3", "02-Nov-2010", "09-Nov-2010", "200.2", "4.2", "100", "0", "7", "304.4"},
            {"4", "09-Nov-2010", "09-Nov-2010", "0", "0", "100", "0", "0", "100"},
            {"Installments due", "", "", "", "", ""},
            {"4", "09-Nov-2010", "-", "201.1", "2.8", "0", "0", "0", "203.9"},
            {"5", "16-Nov-2010", "-", "201.7", "2.8", "100", "0", "0", "304.5"}};//2.3
    public static final String[][] MULTIPLE_DUE_FORTH_ADJUSTMENT = {{"Installments paid", "", "", "", "", ""}, //reversing 200 paid on 09-nov
            {"1", "19-Oct-2010", "04-Nov-2010", "197.7", "5.3", "100", "0", "16", "303"},
            {"2", "26-Oct-2010", "06-Nov-2010", "199.3", "5.8", "100", "0", "11", "305.1"},
            {"3", "02-Nov-2010", "09-Nov-2010", "100.2", "4.2", "100", "0", "7","204.4"},
            {"Installments due", "", "", "", "", ""},
            {"3", "02-Nov-2010", "-", "100", "0", "0", "0", "7", "100"},
            {"4", "09-Nov-2010", "-", "201.1", "4", "100", "0", "0", "305.1"},
            {"5", "16-Nov-2010", "-", "201.7", "2.8", "100", "0", "0", "304.5"}};//2.3
    public static final String[][] MULTIPLE_DUE_FIFTH_ADJUSTMENT = {{"Installments paid", "", "", "", "", ""},//reversing 104 paid on 09-nov
            {"1", "19-Oct-2010", "04-Nov-2010", "197.7", "5.3", "100", "0", "16", "303"},
            {"2", "26-Oct-2010", "06-Nov-2010", "199.3", "5.8", "100", "0", "11", "305.1"},
            {"3", "02-Nov-2010", "", "0", "0", "100", "0", "4", "100"},
            {"Installments due", "", "", "", "", ""},
            {"3", "02-Nov-2010", "-", "200.2", "4.2", "0", "0", "4", "204.4"},
            {"4", "09-Nov-2010", "-", "201.1", "4", "100", "0", "0", "305.1"},
            {"5", "16-Nov-2010", "-", "201.7", "2.8", "100", "0", "0", "304.5"}};//2.3
    public static final String[][] MULTIPLE_DUE_SIXTH_ADJUSTMENT = {{"Installments paid", "", "", "", "", ""}, //reversing 305 on 6-nov
            {"1", "19-Oct-2010", "04-Nov-2010", "197.7", "5.3", "100", "0", "16", "303"},
            {"2", "26-Oct-2010", "", "0", "0", "100", "0", "9", "100"},
            {"Installments due", "", "", "", "", ""},
            {"2", "26-Oct-2010", "-", "199.3", "5.8", "0", "0", "9", "205.1"},
            {"3", "02-Nov-2010", "-", "200.2", "5.8", "100", "0", "2", "306"},
            {"4", "09-Nov-2010", "-", "201.1", "4", "100", "0", "0", "305.1"},
            {"5", "16-Nov-2010", "-", "201.7", "2.8", "100", "0", "0", "304.5"}};//2.3
    public static final String[][] MULTIPLE_DUE_SEVENTH_ADJUSTMENT = {{"Installments due", "", "", "", "", ""}, //reversing 305 on 6-nov
            {"1", "19-Oct-2010", "", "197.7", "5.3", "100", "0", "0", "303"},
            {"2", "26-Oct-2010", "-", "199.3", "7.6", "100", "0", "0", "306.9"},
            {"3", "02-Nov-2010", "-", "200.2", "5.8", "100", "0", "2", "306"},
            {"4", "09-Nov-2010", "-", "201.1", "4", "100", "0", "0", "305.1"},
            {"5", "16-Nov-2010", "-", "201.7", "2.8", "100", "0", "0", "304.5"}};
    public static final String[][] ACCOUNT_SUMMARY_REPAYMENT_ONE = {{"", "Original Loan", "Amount paid", "Loan balance"},
            {"Principal", "1,000", "1,000", "0"},
            {"Interest", "-0.5", "0", "0"}, //0
            {"Fees", "100", "100", "0"},
            {"Penalty", "0", "0", "0"},
            {"Total", "1,099.5", "1,100", "0"}};
    public static final String[][] ACCOUNT_SUMMARY_ADJUSTMENT_ONE = {{"", "Original Loan", "Amount paid", "Loan balance"},
            {"Principal", "1,000","0", "1,000"},
            {"Interest",  "14.5",  "0", "14.5"}, //0
            {"Fees",     "500",  "0", "500"},
            {"Penalty",    "0",  "0", "0"},
            {"Total",  "1,514.5",   "0", "1,514.5"}};
    public static final String[][] ACCOUNT_SUMMARY_REPAYMENT_TWO = {{"", "Original Loan", "Amount paid", "Loan balance"},
            {"Principal", "1,000", "1,000", "0"},
            {"Interest", "11.8", "15.8", "0"}, //14.5
            {"Fees", "400", "400", "0"},
            {"Penalty", "0", "0", "0"},
            {"Total", "1,411.8", "1,415.8", "0"}}; //14.5
    public static final String[][] ACCOUNT_SUMMARY_ADJUSTMENT_TWO = {{"", "Original Loan", "Amount paid", "Loan balance"},
            {"Principal", "1,000", "197.7", "802.3"},
            {"Interest", "14.5", "5.3", "13"},
            {"Fees", "500", "200", "300"},
            {"Penalty", "0", "0", "0"},
            {"Total", "1,514.5", "403", "1,115.3"}};
    public static final String[][] ACCOUNT_SUMMARY_OVERDUE = {
            { "", "Original Loan", "Amount paid", "Loan balance" },            
            {"Principal", "1,000", "0", "1,000"},
            {"Interest", "12", "0", "23.5"},
            {"Fees", "0", "0", "0"},
            {"Penalty", "0", "0", "0"},
            {"Total", "1,012", "0", "1,023.5"}};
    public static final String[][] ACCOUNT_SUMMARY_OVERDUE_REPAYMENT = {
            { "", "Original Loan", "Amount paid", "Loan balance" },            
            {"Principal", "1,000", "1,000", "0"},
            {"Interest", "12", "23.5", "0"},
            {"Fees", "0", "0", "0"},
            {"Penalty", "0", "0", "0"},
            {"Total", "1,012", "1,023.5", "0"}};
}
