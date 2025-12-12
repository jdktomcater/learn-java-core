package com.jdktomcat.pack.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 记录处理
 */
public class StatisticsOrder {

    /**
     * 读取文件
     *
     * @param filePath 文件路径
     * @return 记录列表
     */
    private static Map<String,Map<String,Integer>> readRecordData(String filePath) throws FileNotFoundException {
        Map<String,Map<String,Integer>> result = new HashMap<>();
        Scanner scanner = new Scanner(new File(filePath));
        while (scanner.hasNext()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }
            String[] datas = line.split("\\s+");
            String merchantName = datas[0];
            Map<String,Integer> dataMap = result.getOrDefault(merchantName, new TreeMap<>());
            String createDate = datas[1];
            dataMap.put(createDate, dataMap.getOrDefault(createDate,0)+1);
            result.put(merchantName, dataMap);
        }
        return result;
    }

    /**
     * 读取文件
     *
     * @param filePath 文件路径
     * @return 记录列表
     */
    private static Map<String,String> readNameData(String filePath) throws FileNotFoundException {
        Map<String,String> result = new HashMap<>();
        Scanner scanner = new Scanner(new File(filePath));
        while (scanner.hasNext()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }
            String[] datas = line.split("\\s+");
            String merchantId = datas[0];
            String merchantName = datas[1];
            result.put(merchantName, merchantId + ":" + merchantName);
        }
        return result;
    }

    /**
     * 读取文件
     *
     * @param filePath 文件路径
     * @return 记录列表
     */
    private static Map<Integer,String> readIdData(String filePath) throws FileNotFoundException {
        Map<Integer,String> result = new HashMap<>();
        Scanner scanner = new Scanner(new File(filePath));
        while (scanner.hasNext()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }
            String[] datas = line.split("\\s+");
            Integer merchantId = Integer.parseInt(datas[0]);
            String merchantName = datas[1];
            result.put(merchantId, merchantName);
        }
        return result;
    }

    /**
     * 读取文件
     *
     * @param filePath 文件路径
     * @return 记录列表
     */
    private static Set<Integer> readIdSetData(String filePath) throws FileNotFoundException {
        Set<Integer> result = new HashSet<>();
        Scanner scanner = new Scanner(new File(filePath));
        while (scanner.hasNext()) {
            result.add(Integer.parseInt(scanner.nextLine().trim()));
        }
        return result;
    }



    /**
     * 主函数入口
     *
     * @param args 参数
     */
    public static void main(String[] args) throws IOException, ParseException {
        String fileRecordPath = "C:\\yuhata\\workspace\\github\\jdktomcater\\learn-java-core\\txt\\tw.txt";
        Map<String, Map<String, Integer>> recordResult = readRecordData(fileRecordPath);
        String fileMerchantPath = "C:\\yuhata\\workspace\\github\\jdktomcater\\learn-java-core\\txt\\id_name.txt";
        Map<String,String> merchantNameData = readNameData(fileMerchantPath);
        Map<Integer,String> merchantIdData = readIdData(fileMerchantPath);

        String fileIdPath = "C:\\yuhata\\workspace\\github\\jdktomcater\\learn-java-core\\txt\\merchant_id.txt";
        Set<Integer> merchantIdSet = readIdSetData(fileIdPath);

        String fileDoneIdPath = "C:\\yuhata\\workspace\\github\\jdktomcater\\learn-java-core\\txt\\done.txt";
        Set<Integer> doneIdSet = readIdSetData(fileDoneIdPath);
        doneIdSet.forEach(merchantIdSet::remove);


        merchantIdData.forEach((merchantId,merchantName) -> {
            if(merchantIdSet.contains(merchantId)){
                System.out.println(merchantNameData.get(merchantName));
            }
        });
        merchantIdSet.forEach(id->{
            String name = merchantIdData.get(id);
            System.out.println(merchantNameData.get(name));
            List<Integer> dataList = new ArrayList<>();
            Map<String,Integer> dataMap = recordResult.get(name);
            if(dataMap == null){
                return;
            }
            dataMap.forEach((k,v)->{
                double factor = ThreadLocalRandom.current().nextDouble(0.0200, 0.0500);
                System.out.println(v);
                double value =  v/factor;
                dataList.add((int) value);
            });
            System.out.println("-------");
            dataList.forEach(System.out::println);
        });
    }
}

