package com.WiltonZhan.leetcode.l449SerializeAndDeserializeBst;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CodecTest {
    private final Codec codec = new Codec();

    @Test
    void serDe() {
        Codec.TreeNode root1 = new Codec.TreeNode(1);
        root1.left = new Codec.TreeNode(2);
        root1.right = new Codec.TreeNode(3);
        root1.right.left = new Codec.TreeNode(4);
        root1.right.right = new Codec.TreeNode(5);
        root1.right.right.left = new Codec.TreeNode(6);
        root1.right.right.right = new Codec.TreeNode(7);
        String ser1 = codec.serialize(root1);
        System.out.println(ser1);
        Codec.TreeNode root2 = codec.deserialize(ser1);
        assertEquals(root1.val, root2.val);
        assertEquals(root1.left.val, root2.left.val);
        assertEquals(root1.right.val, root2.right.val);
        assertNull(root2.left.left);
        assertNull(root2.left.right);
        assertEquals(root1.right.left.val, root2.right.left.val);
        assertEquals(root1.right.right.val, root2.right.right.val);
        assertNull(root2.right.left.left);
        assertNull(root2.right.left.right);
        assertEquals(root1.right.right.left.val, root2.right.right.left.val);
        assertEquals(root1.right.right.right.val, root2.right.right.right.val);

        Codec.TreeNode root3 = new Codec.TreeNode(1);
        root3.left = new Codec.TreeNode(2);
        root3.right = new Codec.TreeNode(3);
        root3.right.left = new Codec.TreeNode(4);
        root3.right.right = new Codec.TreeNode(5);
        String ser2 = codec.serialize(root3);
        System.out.println(ser2);
        Codec.TreeNode root4 = codec.deserialize(ser2);
        assertEquals(root3.val, root4.val);
        assertEquals(root3.left.val, root4.left.val);
        assertEquals(root3.right.val, root4.right.val);
        assertNull(root4.left.left);
        assertNull(root4.left.right);
        assertEquals(root3.right.left.val, root4.right.left.val);
        assertEquals(root3.right.right.val, root4.right.right.val);

        Codec.TreeNode root5 = codec.deserialize("1,N,2,N,3,N,4,N,5,N,6,N,7,N,8,N,9,N,10,N,11,N,12,N,13,N,14,N,15,N,16,N,17,N,18,N,19,N,20,N,21,N,22,N,23,N,24,N,25,N,26,N,27,N,28,N,29,N,30,N,31,N,32,N,33,N,34,N,35,N,36,N,37,N,38,N,39,N,40,N,41,N,42,N,43,N,44,N,45,N,46,N,47,N,48,N,49,N,50,N,51,N,52,N,53,N,54,N,55,N,56,N,57,N,58,N,59,N,60,N,61,N,62,N,63,N,64,N,65,N,66,N,67,N,68,N,69,N,70,N,71,N,72,N,73,N,74,N,75,N,76,N,77,N,78,N,79,N,80,N,81,N,82,N,83,N,84,N,85,N,86,N,87,N,88,N,89,N,90,N,91,N,92,N,93,N,94,N,95,N,96,N,97,N,98,N,99,N,100,N,101,N,102,N,103,N,104,N,105,N,106,N,107,N,108,N,109,N,110,N,111,N,112,N,113,N,114,N,115,N,116,N,117,N,118,N,119,N,120,N,121,N,122,N,123,N,124,N,125,N,126,N,127,N,128,N,129,N,130,N,131,N,132,N,133,N,134,N,135,N,136,N,137,N,138,N,139,N,140,N,141,N,142,N,143,N,144,N,145,N,146,N,147,N,148,N,149,N,150,N,151,N,152,N,153,N,154,N,155,N,156,N,157,N,158,N,159,N,160,N,161,N,162,N,163,N,164,N,165,N,166,N,167,N,168,N,169,N,170,N,171,N,172,N,173,N,174,N,175,N,176,N,177,N,178,N,179,N,180,N,181,N,182,N,183,N,184,N,185,N,186,N,187,N,188,N,189,N,190,N,191,N,192,N,193,N,194,N,195,N,196,N,197,N,198,N,199,N,200,N,201,N,202,N,203,N,204,N,205,N,206,N,207,N,208,N,209,N,210,N,211,N,212,N,213,N,214,N,215,N,216,N,217,N,218,N,219,N,220,N,221,N,222,N,223,N,224,N,225,N,226,N,227,N,228,N,229,N,230,N,231,N,232,N,233,N,234,N,235,N,236,N,237,N,238,N,239,N,240,N,241,N,242,N,243,N,244,N,245,N,246,N,247,N,248,N,249,N,250,N,251,N,252,N,253,N,254,N,255,N,256,N,257,N,258,N,259,N,260,N,261,N,262,N,263,N,264,N,265,N,266,N,267,N,268,N,269,N,270,N,271,N,272,N,273,N,274,N,275,N,276,N,277,N,278,N,279,N,280,N,281,N,282,N,283,N,284,N,285,N,286,N,287,N,288,N,289,N,290,N,291,N,292,N,293,N,294,N,295,N,296,N,297,N,298,N,299,N,300,N,301,N,302,N,303,N,304,N,305,N,306,N,307,N,308,N,309,N,310,N,311,N,312,N,313,N,314,N,315,N,316,N,317,N,318,N,319,N,320,N,321,N,322,N,323,N,324,N,325,N,326,N,327,N,328,N,329,N,330,N,331,N,332,N,333,N,334,N,335,N,336,N,337,N,338,N,339,N,340,N,341,N,342,N,343,N,344,N,345,N,346,N,347,N,348,N,349,N,350,N,351,N,352,N,353,N,354,N,355,N,356,N,357,N,358,N,359,N,360,N,361,N,362,N,363,N,364,N,365,N,366,N,367,N,368,N,369,N,370,N,371,N,372,N,373,N,374,N,375,N,376,N,377,N,378,N,379,N,380,N,381,N,382,N,383,N,384,N,385,N,386,N,387,N,388,N,389,N,390,N,391,N,392,N,393,N,394,N,395,N,396,N,397,N,398,N,399,N,400,N,401,N,402,N,403,N,404,N,405,N,406,N,407,N,408,N,409,N,410,N,411,N,412,N,413,N,414,N,415,N,416,N,417,N,418,N,419,N,420,N,421,N,422,N,423,N,424,N,425,N,426,N,427,N,428,N,429,N,430,N,431,N,432,N,433,N,434,N,435,N,436,N,437,N,438,N,439,N,440,N,441,N,442,N,443,N,444,N,445,N,446,N,447,N,448,N,449,N,450,N,451,N,452,N,453,N,454,N,455,N,456,N,457,N,458,N,459,N,460,N,461,N,462,N,463,N,464,N,465,N,466,N,467,N,468,N,469,N,470,N,471,N,472,N,473,N,474,N,475,N,476,N,477,N,478,N,479,N,480,N,481,N,482,N,483,N,484,N,485,N,486,N,487,N,488,N,489,N,490,N,491,N,492,N,493,N,494,N,495,N,496,N,497,N,498,N,499,N,500,N,501,N,502,N,503,N,504,N,505,N,506,N,507,N,508,N,509,N,510,N,511,N,512,N,513,N,514,N,515,N,516,N,517,N,518,N,519,N,520,N,521,N,522,N,523,N,524,N,525,N,526,N,527,N,528,N,529,N,530,N,531,N,532,N,533,N,534,N,535,N,536,N,537,N,538,N,539,N,540,N,541,N,542,N,543,N,544,N,545,N,546,N,547,N,548,N,549,N,550,N,551,N,552,N,553,N,554,N,555,N,556,N,557,N,558,N,559,N,560,N,561,N,562,N,563,N,564,N,565,N,566,N,567,N,568,N,569,N,570,N,571,N,572,N,573,N,574,N,575,N,576,N,577,N,578,N,579,N,580,N,581,N,582,N,583,N,584,N,585,N,586,N,587,N,588,N,589,N,590,N,591,N,592,N,593,N,594,N,595,N,596,N,597,N,598,N,599,N,600,N,601,N,602,N,603,N,604,N,605,N,606,N,607,N,608,N,609,N,610,N,611,N,612,N,613,N,614,N,615,N,616,N,617,N,618,N,619,N,620,N,621,N,622,N,623,N,624,N,625,N,626,N,627,N,628,N,629,N,630,N,631,N,632,N,633,N,634,N,635,N,636,N,637,N,638,N,639,N,640,N,641,N,642,N,643,N,644,N,645,N,646,N,647,N,648,N,649,N,650,N,651,N,652,N,653,N,654,N,655,N,656,N,657,N,658,N,659,N,660,N,661,N,662,N,663,N,664,N,665,N,666,N,667,N,668,N,669,N,670,N,671,N,672,N,673,N,674,N,675,N,676,N,677,N,678,N,679,N,680,N,681,N,682,N,683,N,684,N,685,N,686,N,687,N,688,N,689,N,690,N,691,N,692,N,693,N,694,N,695,N,696,N,697,N,698,N,699,N,700,N,701,N,702,N,703,N,704,N,705,N,706,N,707,N,708,N,709,N,710,N,711,N,712,N,713,N,714,N,715,N,716,N,717,N,718,N,719,N,720,N,721,N,722,N,723,N,724,N,725,N,726,N,727,N,728,N,729,N,730,N,731,N,732,N,733,N,734,N,735,N,736,N,737,N,738,N,739,N,740,N,741,N,742,N,743,N,744,N,745,N,746,N,747,N,748,N,749,N,750,N,751,N,752,N,753,N,754,N,755,N,756,N,757,N,758,N,759,N,760,N,761,N,762,N,763,N,764,N,765,N,766,N,767,N,768,N,769,N,770,N,771,N,772,N,773,N,774,N,775,N,776,N,777,N,778,N,779,N,780,N,781,N,782,N,783,N,784,N,785,N,786,N,787,N,788,N,789,N,790,N,791,N,792,N,793,N,794,N,795,N,796,N,797,N,798,N,799,N,800,N,801,N,802,N,803,N,804,N,805,N,806,N,807,N,808,N,809,N,810,N,811,N,812,N,813,N,814,N,815,N,816,N,817,N,818,N,819,N,820,N,821,N,822,N,823,N,824,N,825,N,826,N,827,N,828,N,829,N,830,N,831,N,832,N,833,N,834,N,835,N,836,N,837,N,838,N,839,N,840,N,841,N,842,N,843,N,844,N,845,N,846,N,847,N,848,N,849,N,850,N,851,N,852,N,853,N,854,N,855,N,856,N,857,N,858,N,859,N,860,N,861,N,862,N,863,N,864,N,865,N,866,N,867,N,868,N,869,N,870,N,871,N,872,N,873,N,874,N,875,N,876,N,877,N,878,N,879,N,880,N,881,N,882,N,883,N,884,N,885,N,886,N,887,N,888,N,889,N,890,N,891,N,892,N,893,N,894,N,895,N,896,N,897,N,898,N,899,N,900,N,901,N,902,N,903,N,904,N,905,N,906,N,907,N,908,N,909,N,910,N,911,N,912,N,913,N,914,N,915,N,916,N,917,N,918,N,919,N,920,N,921,N,922,N,923,N,924,N,925,N,926,N,927,N,928,N,929,N,930,N,931,N,932,N,933,N,934,N,935,N,936,N,937,N,938,N,939,N,940,N,941,N,942,N,943,N,944,N,945,N,946,N,947,N,948,N,949,N,950,N,951,N,952,N,953,N,954,N,955,N,956,N,957,N,958,N,959,N,960,N,961,N,962,N,963,N,964,N,965,N,966,N,967,N,968,N,969,N,970,N,971,N,972,N,973,N,974,N,975,N,976,N,977,N,978,N,979,N,980,N,981,N,982,N,983,N,984,N,985,N,986,N,987,N,988,N,989,N,990,N,991,N,992,N,993,N,994,N,995,N,996,N,997,N,998,N,999,N,1000");
        System.out.println(codec.serialize(root5));

        Codec.TreeNode root7 = new Codec.TreeNode(1);
        String ser4 = codec.serialize(root7);
        System.out.println(ser4);
        codec.deserialize(ser4);
    }
}