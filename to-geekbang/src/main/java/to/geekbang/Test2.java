package to.geekbang;

/**
 * 非空数组，类型int
 * 只有一个数是单独出现的，其他的数都是成对出现的，找出数组中单独出现的数字
 * [2,2,1]->1
 */
public class Test2 {

    public int findNum(int[] nums) {
        return -1;
    }
}

interface Product {
    Product getInstance();
}

class AppleProduct implements Product {

    @Override
    public Product getInstance() {
        return new AppleProduct();
    }
}

class PairProduct implements Product {
    @Override
    public Product getInstance() {
        return new PairProduct();
    }
}

class Factory {

    public static Product getProduct(String type) {
        if ("apple".equals(type)) return new AppleProduct().getInstance();
        if ("pair".equals(type)) return new PairProduct().getInstance();
        else return null;
    }
}
