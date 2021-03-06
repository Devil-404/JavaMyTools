package com.zyd.tools.custom;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @description:随机生成数据
 * @projectName:MyTool
 * @see:com.zyd.tool
 * @author:张屹东
 * @createTime:2020/7/14 16:12
 */
public final class RandomDataUtil {

    private static final String base = "abcdefghijklmnopqrstuvwxyz0123456789";
    private static final String firstName = "赵钱孙李周吴郑王冯陈褚卫蒋沈韩杨朱秦尤许何吕施张孔曹严华金魏陶姜戚谢邹喻柏水窦章云苏潘葛奚范彭郎鲁韦昌马苗凤花方俞任袁柳酆鲍史唐费廉岑薛雷贺倪汤滕殷罗毕郝邬安常乐于时傅皮卞齐康伍余元卜顾孟平黄和穆萧尹姚邵湛汪祁毛禹狄米贝明臧计伏成戴谈宋茅庞熊纪舒屈项祝董梁杜阮蓝闵席季麻强贾路娄危江童颜郭梅盛林刁钟徐邱骆高夏蔡田樊胡凌霍虞万支柯咎管卢莫经房裘缪干解应宗宣丁贲邓郁单杭洪包诸左石崔吉钮龚程嵇邢滑裴陆荣翁荀羊於惠甄魏加封芮羿储靳汲邴糜松井段富巫乌焦巴弓牧隗山谷车侯宓蓬全郗班仰秋仲伊宫宁仇栾暴甘钭厉戎祖武符刘姜詹束龙叶幸司韶郜黎蓟薄印宿白怀蒲台从鄂索咸籍赖卓蔺屠蒙池乔阴郁胥能苍双闻莘党翟谭贡劳逄姬申扶堵冉宰郦雍却璩桑桂濮牛寿通边扈燕冀郏浦尚农温别庄晏柴瞿阎充慕连茹习宦艾鱼容向古易慎戈廖庚终暨居衡步都耿满弘匡国文寇广禄阙东殴殳沃利蔚越夔隆师巩厍聂晁勾敖融冷訾辛阚那简饶空曾毋沙乜养鞠须丰巢关蒯相查后江红游竺权逯盖益桓公万俟司马上官欧阳夏侯诸葛闻人东方赫连皇甫尉迟公羊澹台公冶宗政濮阳淳于仲孙太叔申屠公孙乐正轩辕令狐钟离闾丘长孙慕容鲜于宇文司徒司空亓官司寇仉督子车颛孙端木巫马公西漆雕乐正壤驷公良拓拔夹谷宰父谷粱晋楚阎法汝鄢涂钦段干百里东郭南门呼延归海羊舌微生岳帅缑亢况后有琴梁丘左丘东门西门商牟佘佴伯赏南宫墨哈谯笪年爱阳佟第五言福百家姓续";
    private static final String girl = "秀娟英华慧巧美娜静淑惠珠翠雅芝玉萍红娥玲芬芳燕彩春菊兰凤洁梅琳素云莲真环雪荣爱妹霞香月莺媛艳瑞凡佳嘉琼勤珍贞莉桂娣叶璧璐娅琦晶妍茜秋珊莎锦黛青倩婷姣婉娴瑾颖露瑶怡婵雁蓓纨仪荷丹蓉眉君琴蕊薇菁梦岚苑婕馨瑗琰韵融园艺咏卿聪澜纯毓悦昭冰爽琬茗羽希宁欣飘育滢馥筠柔竹霭凝晓欢霄枫芸菲寒伊亚宜可姬舒影荔枝思丽 ";
    private static final String boy = "伟刚勇毅俊峰强军平保东文辉力明永健世广志义兴良海山仁波宁贵福生龙元全国胜学祥才发武新利清飞彬富顺信子杰涛昌成康星光天达安岩中茂进林有坚和彪博诚先敬震振壮会思群豪心邦承乐绍功松善厚庆磊民友裕河哲江超浩亮政谦亨奇固之轮翰朗伯宏言若鸣朋斌梁栋维启克伦翔旭鹏泽晨辰士以建家致树炎德行时泰盛雄琛钧冠策腾楠榕风航弘";
    private static final String[] road = (" 广东省广州市, 广东省深圳市, 广东省汕头市, 广东省湛江市, 广东省韶关市, 广东省珠海市, 广东省佛山市, 广东省江门市, 广东省茂名市, 广东省肇庆市, 广东省惠州市, 广东省梅州市, 广东省阳江市, 广东省东莞市, 广东省中山市, 广东省潮州市, 广东省汕尾市, 广东省河源市, 广东省清远市, 广东省揭阳市, 广东省云浮市, 广东省番禺市, 广东省花都市, 广东省增城市, 广东省从化市, 广东省乐昌市, 广东省南雄市, 广东省潮阳市, 广东省澄海市, 广东省顺德市, 广东省南海市, 广东省三水市, 广东省高明市, 广东省台山市, 广东省新会市, 广东省开平市, 广东省鹤山市, 广东省恩平市, 广东省廉江市, 广东省雷州市, 广东省吴川市, 广东省高州市, 广东省化州市, 广东省信宜市, 广东省高要市, 广东省四会市, 广东省惠阳市, 广东省兴宁市, 广东省陆丰市, 广东省阳春市, 广东省英德市, 广东省连州市, 广东省普宁市, 广东省罗定市," +
            "" +
            "陕西省西安市, 陕西省铜川市, 陕西省宝鸡市, 陕西省咸阳市, 陕西省汉中市, 陕西省渭南市, 陕西省延安市, 陕西省榆林市, 陕西省兴平市, 陕西省韩城市, 陕西省华阴市, 陕西省安康市, 陕西省商州市," +
            "" +
            "河南省郑州市, 河南省开封市, 河南省洛阳市, 河南省平顶山市, 河南省安阳市, 河南省新乡市, 河南省焦作市, 河南省鹤壁市, 河南省濮阳市, 河南省许昌市, 河南省漯河市, 河南省南阳市, 河南省商丘市, 河南省三门峡市, 河南省信阳市, 河南省巩义市, 河南省荥阳市, 河南省新密市, 河南省新郑市, 河南省登封市, 河南省偃师市, 河南省舞钢市, 河南省汝州市, 河南省林州市, 河南省卫辉市, 河南省辉县市, 河南省济源市, 河南省沁阳市, 河南省孟州市, 河南省禹州市," +
            "" +
            "河南省长葛市, 河南省义马市, 河南省灵宝市, 河南省邓州市, 河南省永城市, 河南省周口市, 河南省项城市, 河南省驻马店市," +
            "" +
            "江西省南昌市, 江西省景德镇市, 江西省萍乡市, 江西省九江市, 江西省新余市, 江西省鹰潭市, 江西省赣州市, 江西省乐平市, 江西省瑞昌市, 江西省贵溪市, 江西省瑞金市, 江西省南康市, 江西省宜春市, 江西省丰城市, 江西省樟树市, 江西省高安市, 江西省上饶市, 江西省德兴市, 江西省吉安市, 江西省井冈山市, 江西省临川市," +
            "海南省海口市, 海南省三亚市, 海南省通什市, 海南省琼海市, 海南省儋州市, 海南省琼山市, 海南省文昌市, 海南省万宁市, 海南省东方市," +
            "" +
            "广西南宁市, 广西柳州市, 广西桂林市, 广西梧州市, 广西贵港市, 广西北海市, 广西防城港市, 广西钦州市, 广西玉林市, 广西岑溪市, 广西东兴市, 广西桂平市, 广西北流市, 广西凭祥市, 广西合山市, 广西贺州市, 广西百色市, 广西河池市, 广西宜州市," +
            "" +
            "吉林省长春市, 吉林省吉林市, 吉林省四平市, 吉林省辽源市, 吉林省通化市, 吉林省白山市, 吉林省松原市, 吉林省白城市, 吉林省九台市, 吉林省榆树市, 吉林省德惠市, 吉林省蛟河市, 吉林省桦甸市, 吉林省舒兰市, 吉林省磐石市, 吉林省公主岭市, 吉林省双辽市, 吉林省梅河口市, 吉林省集安市, 吉林省临江市, 吉林省洮南市, 吉林省大安市, 吉林省延吉市, 吉林省图们市, 吉林省敦化市, 吉林省珲春市, 吉林省龙井市, 吉林省和龙市," +
            "" +
            "上海市,北京市,新疆乌鲁木齐市, 新疆克拉玛依市, 新疆吐鲁番市, 新疆哈密市, 新疆昌吉市, 新疆阜康市, 新疆米泉市, 新疆博乐市, 新疆库尔勒市, 新疆阿克苏市, 新疆阿图什市, 新疆喀什市, 新疆和田市, 新疆奎屯市, 新疆伊宁市, 新疆塔城市, 新疆乌苏市, 新疆阿勒泰市," +
            "" +
            "" +
            "吉林省长春市, 吉林省吉林市, 吉林省四平市, 吉林省辽源市, 吉林省通化市, 吉林省白山市, 吉林省松原市, 吉林省白城市, 吉林省九台市, 吉林省榆树市, 吉林省德惠市, 吉林省蛟河市, 吉林省桦甸市, 吉林省舒兰市, 吉林省磐石市, 吉林省公主岭市, 吉林省双辽市, 吉林省梅河口市, 吉林省集安市, 吉林省临江市, 吉林省洮南市, 吉林省大安市, 吉林省延吉市, 吉林省图们市, 吉林省敦化市, 吉林省珲春市, 吉林省龙井市, 吉林省和龙市," +
            "" +
            "宁夏银川市, 宁夏石嘴山市, 宁夏吴忠市, 宁夏青铜峡市, 宁夏灵武市," +
            "" +
            "安徽省合肥市, 安徽省淮南市, 安徽省淮北市, 安徽省芜湖市, 安徽省蚌埠市, 安徽省马鞍山市, 安徽省铜陵市, 安徽省安庆市, 安徽省阜阳市, 安徽省黄山市, 安徽省滁州市, 安徽省宿州市, 安徽省巢湖市, 安徽省六安市, 安徽省桐城市, 安徽省天长市, 安徽省明光市, 安徽省亳州市, 安徽省界首市, 安徽省宣州市, 安徽省宁国市, 安徽省贵池市," +
            "" +
            "河北省石家庄市, 河北省唐山市, 河北省邯郸市, 河北省保定市, 河北省张家口市, 河北省秦皇岛市, 河北省邢台市, 河北省承德市, 河北省沧州市, 河北省廊坊市, 河北省衡水市, 河北省辛集市, 河北省藁城市, 河北省晋州市, 河北省新乐市, 河北省鹿泉市, 河北省遵化市, 河北省丰南市, 河北省迁安市, 河北省武安市, 河北省南宫市, 河北省沙河市, 河北省涿州市, 河北省定州市, 河北省安国市, 河北省高碑店市, 河北省泊头市, 河北省任丘市, 河北省黄骅市, 河北省河间市, 河北省霸州市, 河北省三河市, 河北省冀州市, 河北省深州市," +
            "" +
            "甘肃省兰州市, 甘肃省白银市, 甘肃省天水市, 甘肃省嘉峪关市, 甘肃省金昌市, 甘肃省玉门市, 甘肃省酒泉市, 甘肃省敦煌市, 甘肃省张掖市, 甘肃省武威市, 甘肃省平凉市, 甘肃省西峰市, 甘肃省临夏市, 甘肃省合作市," +
            "" +
            "山西省太原市, 山西省大同市, 山西省阳泉市, 山西省长治市, 山西省晋城市, 山西省朔州市, 山西省古交市, 山西省潞城市, 山西省高平市, 山西省忻州市, 山西省原平市, 山西省孝义市, 山西省离石市, 山西省汾阳市, 山西省榆次市, 山西省介休市, 山西省临汾市, 山西省侯马市, 山西省霍州市, 山西省运城市, 山西省永济市, 山西省河津市," +
            "" +
            "江苏省南京市, 江苏省徐州市, 江苏省无锡市, 江苏省常州市, 江苏省苏州市, 江苏省南通市, 江苏省连云港市, 江苏省淮阴市, 江苏省盐城市, 江苏省扬州市, 江苏省镇江市, 江苏省泰州市, 江苏省宿迁市, 江苏省江阴市, 江苏省宜兴市, 江苏省锡山市, 江苏省新沂市, 江苏省邳州市, 江苏省溧阳市, 江苏省金坛市, 江苏省武进市, 江苏省常熟市, 江苏省张家港市, 江苏省昆山市, 江苏省吴江市, 江苏省太仓市, 江苏省吴县市, 江苏省启东市, 江苏省如皋市, 江苏省通州市, 江苏省海门市, 江苏省淮安市, 江苏省东台市, 江苏省大丰市, 江苏省仪征市, 江苏省高邮市, 江苏省江都市, 江苏省丹阳市, 江苏省扬中市, 江苏省句容市, 江苏省兴化市, 江苏省靖江市, 江苏省泰兴市, 江苏省姜堰市," +
            "" +
            "四川省成都市, 四川省自贡市, 四川省攀枝花市, 四川省泸州市, 四川省德阳市, 四川省绵阳市, 四川省广元市, 四川省遂宁市, 四川省内江市, 四川省乐山市, 四川省南充市, 四川省宜宾市, 四川省达州市, 四川省都江堰市, 四川省彭州市, 四川省邛崃市, 四川省崇州市, 四川省广汉市, 四川省什邡市, 四川省绵竹市, 四川省江油市, 四川省峨眉山市, 四川省阆中市, 四川省华蓥市, 四川省万源市, 四川省雅安市, 四川省西昌市, 四川省巴中市, 四川省资阳市, 四川省简阳市, 四川省广安市," +
            "" +
            "福建省福州市, 福建省厦门市, 福建省泉州市, 福建省漳州市, 福建省南平市, 福建省龙岩市, 福建省莆田市, 福建省三明市, 福建省福清市, 福建省长乐市, 福建省永安市, 福建省石狮市, 福建省晋江市, 福建省南安市, 福建省龙海市, 福建省邵武市, 福建省武夷山市, 福建省建瓯市, 福建省建阳市, 福建省漳平市, 福建省宁德市, 福建省福安市, 福建省福鼎市," +
            "" +
            "内蒙包头市, 内蒙呼和浩特市, 内蒙乌海市, 内蒙赤峰市, 内蒙通辽市, 内蒙霍林郭勒市, 内蒙海拉尔市, 内蒙满洲里市, 内蒙扎兰屯市, 内蒙牙克石市, 内蒙根河市, 内蒙额尔古纳市, 内蒙乌兰浩特市, 内蒙二连浩特市, 内蒙锡林浩特市, 内蒙集宁市, 内蒙丰镇市, 内蒙东胜市, 内蒙临河市," +
            "" +
            "湖南省长沙市, 湖南省株洲市, 湖南省湘潭市, 湖南省衡阳市, 湖南省邵阳市, 湖南省岳阳市, 湖南省常德市, 湖南省益阳市, 湖南省郴州市, 湖南省永州市, 湖南省怀化市, 湖南省张家界市, 湖南省娄底市, 湖南省浏阳市, 湖南省醴陵市, 湖南省湘乡市, 湖南省韶山市, 湖南省耒阳市, 湖南省常宁市, 湖南省武冈市, 湖南省汩罗市, 湖南省临湘市, 湖南省津市, 湖南省沅江市, 湖南省资兴市, 湖南省洪江市, 湖南省冷水江市, 湖南省涟源市, 湖南省吉首市," +
            "" +
            "贵州省贵阳市, 贵州省六盘水市, 贵州省遵义市, 贵州省清镇市, 贵州省赤水市, 贵州省仁怀市, 贵州省铜仁市, 贵州省兴义市, 贵州省毕节市, 贵州省安顺市, 贵州省凯里市, 贵州省都匀市, 贵州省福泉市," +
            "" +
            "辽宁省沈阳市, 辽宁省大连市, 辽宁省鞍山市, 辽宁省抚顺市, 辽宁省本溪市, 辽宁省丹东市, 辽宁省锦州市, 辽宁省阜新市, 辽宁省辽阳市, 辽宁省营口市, 辽宁省盘锦市, 辽宁省铁岭市, 辽宁省朝阳市, 辽宁省葫芦岛市, 辽宁省新民市, 辽宁省瓦房店市, 辽宁省普兰店市, 辽宁省庄河市, 辽宁省海城市, 辽宁省东港市, 辽宁省凤城市, 辽宁省凌海市, 辽宁省北宁市, 辽宁省盖州市, 辽宁省大石桥市, 辽宁省灯塔市, 辽宁省铁法市, 辽宁省开原市, 辽宁省北票市, 辽宁省凌源市, 辽宁省兴城市," +
            "" +
            "山东省济南市, 山东省青岛市, 山东省淄博市, 山东省枣庄市, 山东省烟台市, 山东省潍坊市, 山东省泰安市, 山东省临沂市, 山东省东营市, 山东省济宁市, 山东省威海市, 山东省日照市, 山东省莱芜市, 山东省德州市, 山东省聊城市, 山东省章丘市, 山东省胶州市, 山东省即墨市, 山东省平度市, 山东省胶南市, 山东省莱西市, 山东省滕州市, 山东省龙口市, 山东省莱阳市, 山东省莱州市, 山东省蓬莱市, 山东省招远市, 山东省栖霞市, 山东省海阳市, 山东省青州市, 山东省诸城市, 山东省寿光市, 山东省安丘市, 山东省高密市, 山东省昌邑市, 山东省曲阜市, 山东省兖州市, 山东省邹城市, 山东省新泰市, 山东省肥城市, 山东省文登市, 山东省荣成市, 山东省乳山市, 山东省乐陵市, 山东省禹城市, 山东省临清市, 山东省滨州市, 山东省菏泽市,"
    ).split(",");
    private static final String[] email_suffix = "@gmail.com,@yahoo.com,@msn.com,@hotmail.com,@aol.com,@ask.com,@live.com,@qq.com,@0355.net,@163.com,@163.net,@263.net,@3721.net,@yeah.net,@googlemail.com,@126.com,@sina.com,@sohu.com,@yahoo.com.cn".split(",");

    public static int getNum(int start, int end) {
        return (int) (Math.random() * (end - start + 1) + start);
    }

    /**
     * 获取随机生成的身份证号码
     *
     * @return
     */
    public static String getRandomID() {
        String id;
        // 随机生成省、自治区、直辖市代码 1-2
        String[] provinces = {"11", "12", "13", "14", "15", "21", "22", "23",
                "31", "32", "33", "34", "35", "36", "37", "41", "42", "43",
                "44", "45", "46", "50", "51", "52", "53", "54", "61", "62",
                "63", "64", "65", "71", "81", "82"};
        String province = randomOne(provinces);
        // 随机生成地级市、盟、自治州代码 3-4
        String city = randomCityCode(18);
        // 随机生成县、县级市、区代码 5-6
        String county = randomCityCode(28);
        // 随机生成出生年月 7-14
        String birth = randomBirth(20, 50);
        // 随机生成顺序号 15-17(随机性别)
        String no = new Random().nextInt(899) + 100 + "";
        // 随机生成校验码 18
        String[] checks = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
                "X"};
        String check = randomOne(checks);
        // 拼接身份证号码
        id = province + city + county + birth + no + check;
        return id;
    }

    /**
     * 从String[] 数组中随机取出其中一个String字符串
     *
     * @param s
     * @return
     */
    private static String randomOne(String[] s) {
        return s[new Random().nextInt(s.length - 1)];
    }

    /**
     * 随机生成两位数的字符串（01-max）,不足两位的前面补0
     *
     * @param max
     * @return
     */
    private static String randomCityCode(int max) {
        int i = new Random().nextInt(max) + 1;
        return i > 9 ? i + "" : "0" + i;
    }

    /**
     * 随机生成minAge到maxAge年龄段的人的生日日期
     *
     * @param minAge
     * @param maxAge
     * @return
     */
    public static String randomBirth(int minAge, int maxAge) {
        SimpleDateFormat dft = new SimpleDateFormat("yyyyMMdd");// 设置日期格式
        Calendar date = Calendar.getInstance();
        date.setTime(new Date());// 设置当前日期
        // 随机设置日期为前maxAge年到前minAge年的任意一天
        int randomDay = 365 * minAge
                + new Random().nextInt(365 * (maxAge - minAge));
        date.set(Calendar.DATE, date.get(Calendar.DATE) - randomDay);
        return dft.format(date.getTime());
    }

    /**
     * 返回Email
     *
     * @param lMin 最小长度
     * @param lMax 最大长度
     * @return
     */
    public static String getEmail(int lMin, int lMax) {
        int length = getNum(lMin, lMax);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int number = (int) (Math.random() * base.length());
            sb.append(base.charAt(number));
        }
        sb.append(email_suffix[(int) (Math.random() * email_suffix.length)]);
        return sb.toString();
    }

    /**
     * 返回手机号码
     */
    private static final String[] telFirst = "134,135,136,137,138,139,150,151,152,157,158,159,130,131,132,155,156,133,153".split(",");

    private static String getTel() {
        int index = getNum(0, telFirst.length - 1);
        String first = telFirst[index];
        String second = String.valueOf(getNum(1, 888) + 10000).substring(1);
        String third = String.valueOf(getNum(1, 9100) + 10000).substring(1);
        return first + second + third;
    }

    /**
     * 返回中文姓名
     */
    private static String name_sex = "";

    private static String getChineseName() {
        int index = getNum(0, firstName.length() - 1);
        String first = firstName.substring(index, index + 1);
        int sex = getNum(0, 1);
        String str = boy;
        int length = boy.length();
        if (sex == 0) {
            str = girl;
            length = girl.length();
            name_sex = "女";
        } else {
            name_sex = "男";

        }
        index = getNum(0, length - 1);
        String second = str.substring(index, index + 1);
        int hasThird = getNum(0, 1);
        String third = "";
        if (hasThird == 1) {
            index = getNum(0, length - 1);
            third = str.substring(index, index + 1);
        }
        return first + second + third;

    }

    /**
     * 返回地址
     *
     * @return
     */
    private static String getRoad() {
        return road[getNum(0, road.length - 1)] + getNum(11, 150) + "号" + "-" + getNum(1, 20) + "-" + getNum(1, 10);
    }

    /**
     * 数据封装
     *
     * @return
     */
    public static Map<String, Object> getAddress() {
//        RandomValueUtil cre = new RandomValueUtil();
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("name", getChineseName());
        map.put("sex", name_sex);
        map.put("road", getRoad());
        map.put("tel", getTel());
        map.put("email", getEmail(6, 9));
        map.put("idCard", getRandomID());
        return map;
    }
}
