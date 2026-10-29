public class CryptoEngine {

    private byte[] key;

    public CryptoEngine(String keyString) {
        this.key = keyString.getBytes();
    }

    public byte[] encrypt(byte[] data) {
        byte[] result = xorWithKey(data);
        result = shiftBitsLeft(result);
        return result;
    }

    private byte[] xorWithKey(byte[] data) {
        byte[] output = new byte[data.length];
        for (int i = 0; i < data.length; i++) {
            output[i] = (byte) (data[i] ^ key[i % key.length]);
        }
        return output;
    }

    private byte[] shiftBitsLeft(byte[] data) {
        byte[] output = new byte[data.length];
        for (int i = 0; i < data.length; i++) {
            output[i] = (byte) ((data[i] & 0xFF) << 1 | (data[i] & 0xFF) >>> 7);
        }
        return output;
    }
}
