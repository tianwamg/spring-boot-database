package com.db.nosqlredis.filter;

import java.util.BitSet;

/**
 * 自定义Bloom过滤器
 */
public class MyBloomFilter {

    /**
     * 位数组大小
     */
    private static final int DEFAULT_SIZE = 2<<24;

    /**
     * 通过该数组创建6个不同的hash函数
     */
    private static final int[] SEEDS = new int[]{3,13,46,71,91,134};

    /**
     * 位数组,位数组中的元素只能是0或1
     */
    private BitSet bits = new BitSet(DEFAULT_SIZE);

    /**
     * 存放包含hash函数的类的数组
     */
    private SimpleHash[] func = new SimpleHash[SEEDS.length];

    public MyBloomFilter(){
        for(int i=0;i<SEEDS.length;i++){
            func[i] = new SimpleHash(DEFAULT_SIZE,SEEDS[i]);
        }
    }

    /**
     * 添加元素到数组
     * @param value
     */
    public void add(Object value){
        for(SimpleHash f: func){
            bits.set(f.hash(value),true);
        }
    }

    /**
     * 判断元素是否存在
     * @param value
     * @return
     */
    public boolean contains(Object value){
        boolean res = true;
        for(SimpleHash f: func){
            res = res && bits.get(f.hash(value));
        }
        return res;
    }

    /**
     * 静态内部类,用于hash操作
     */
    public static class SimpleHash{

        private int capacity;

        private int seed;

        public SimpleHash(int capacity,int seed){
            this.capacity = capacity;
            this.seed = seed;
        }

        /**
         * 计算hash值
         * @param value
         * @return
         */
        public int hash(Object value){
            int h;
            return (value== null)?0:Math.abs(seed * (capacity-1) & ((h=value.hashCode())^(h>>>16)));
        }
    }
}
