package com.example.bmpcollect;


public final class f
{
    static final long[] a;

    static {
        a = new long[] { 3523407757L, 2768625435L, 1007455905L, 1259060791L, 3580832660L, 2724731650L, 996231864L, 1281784366L, 3705235391L, 2883475241L, 852952723L, 1171273221L, 3686048678L, 2897449776L, 901431946L, 1119744540L, 3484811241L, 3098726271L, 565944005L, 1455205971L, 3369614320L, 3219065702L, 651582172L, 1372678730L, 3245242331L, 3060352845L, 794826487L, 1483155041L, 3322131394L, 2969862996L, 671994606L, 1594548856L, 3916222277L, 2657877971L, 123907689L, 1885708031L, 3993045852L, 2567322570L, 1010288L, 1997036262L, 3887548279L, 2427484129L, 163128923L, 2126386893L, 3772416878L, 2547889144L, 248832578L, 2043925204L, 4108050209L, 2212294583L, 450215437L, 1842515611L, 4088798008L, 2226203566L, 498629140L, 1790921346L, 4194326291L, 2366072709L, 336475711L, 1661535913L, 4251816714L, 2322244508L, 325317158L, 1684325040L, 2766056989L, 3554254475L, 1255198513L, 1037565863L, 2746444292L, 3568589458L, 1304234792L, 985283518L, 2852464175L, 3707901625L, 1141589763L, 856455061L, 2909332022L, 3664761504L, 1130791706L, 878818188L, 3110715001L, 3463352047L, 1466425173L, 543223747L, 3187964512L, 3372436214L, 1342839628L, 655174618L, 3081909835L, 3233089245L, 1505515367L, 784033777L, 2967466578L, 3352871620L, 1590793086L, 701932520L, 2679148245L, 3904355907L, 1908338681L, 112844655L, 2564639436L, 4024072794L, 1993550816L, 30677878L, 2439710439L, 3865851505L, 2137352139L, 140662621L, 2517025534L, 3775001192L, 2013832146L, 252678980L, 2181537457L, 4110462503L, 1812594589L, 453955339L, 2238339752L, 4067256894L, 1801730948L, 476252946L, 2363233923L, 4225443349L, 1657960367L, 366298937L, 2343686810L, 4239843852L, 1707062198L, 314082080L, 1069182125L, 1220369467L, 3518238081L, 2796764439L, 953657524L, 1339070498L, 3604597144L, 2715744526L, 828499103L, 1181144073L, 3748627891L, 2825434405L, 906764422L, 1091244048L, 3624026538L, 2936369468L, 571309257L, 1426738271L, 3422756325L, 3137613171L, 627095760L, 1382516806L, 3413039612L, 3161057642L, 752284923L, 1540473965L, 3268974039L, 3051332929L, 733688034L, 1555824756L, 3316994510L, 2998034776L, 81022053L, 1943239923L, 3940166985L, 2648514015L, 62490748L, 1958656234L, 3988253008L, 2595281350L, 168805463L, 2097738945L, 3825313147L, 2466682349L, 224526414L, 2053451992L, 3815530850L, 2490061300L, 425942017L, 1852075159L, 4151131437L, 2154433979L, 504272920L, 1762240654L, 4026595636L, 2265434530L, 397988915L, 1623188645L, 4189500703L, 2393998729L, 282398762L, 1741824188L, 4275794182L, 2312913296L, 1231433021L, 1046551979L, 2808630289L, 3496967303L, 1309403428L, 957143474L, 2684717064L, 3607279774L, 1203610895L, 817534361L, 2847130659L, 3736401077L, 1087398166L, 936857984L, 2933784634L, 3654889644L, 1422998873L, 601230799L, 3135200373L, 3453512931L, 1404893504L, 616286678L, 3182598252L, 3400902906L, 1510651243L, 755860989L, 3020215367L, 3271812305L, 1567060338L, 710951396L, 3010007134L, 3295551688L, 1913130485L, 84884835L, 2617666777L, 3942734927L, 1969605100L, 40040826L, 2607524032L, 3966539862L, 2094237127L, 198489425L, 2464015595L, 3856323709L, 2076066270L, 213479752L, 2511347954L, 3803648100L, 1874795921L, 414723335L, 2175892669L, 4139142187L, 1758648712L, 534112542L, 2262612132L, 4057696306L, 1633981859L, 375629109L, 2406151311L, 4167943193L, 1711886778L, 286155052L, 2282172566L, 4278190080L };
    }

    public static long bH(final String s) {
        final int length = s.length();
        long n = 0L;
        for (int i = 0; i < length; ++i) {
            n = (n >>> 8 ^ f.a[(int)((0xFFL & n) ^ (long)s.charAt(i))]);
        }
        return n;
    }
}
