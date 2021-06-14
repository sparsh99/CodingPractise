package arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class DuplicateInArray {

  public static void main(String[] args) {
    System.out.println(
    new DuplicateInArray().repeatedNumber(
        Arrays.asList(
            26, 307, 10, 410, 143, 118, 262, 6, 231, 175, 394, 2, 359, 408, 455, 13, 430, 412, 94, 121, 41, 63, 330, 165, 240, 169, 230, 99, 221, 192, 461, 313, 70, 427, 462, 30, 125, 133, 297, 187, 102, 74, 318, 375, 241, 22, 149, 259, 217, 226, 134, 148, 238, 440, 166, 28, 459, 306, 197, 454, 256, 389, 194, 248, 180, 456, 321, 279, 120, 250, 300, 355, 183, 272, 465, 27, 209, 327, 407, 122, 222, 308, 334, 200, 154, 91, 116, 263, 11, 83, 172, 98, 283, 301, 444, 173, 213, 25, 471, 144, 324, 368, 233, 317, 373, 108, 382, 176, 413, 384, 190, 17, 360, 388, 354, 448, 340, 24, 419, 184, 296, 177, 78, 128, 56, 329, 31, 428, 434, 285, 381, 42, 159, 9, 458, 7, 365, 357, 65, 281, 275, 326, 32, 377, 205, 109, 247, 87, 258, 163, 364, 290, 406, 39, 171, 282, 291, 168, 29, 193, 452, 111, 114, 44, 268, 335, 174, 356, 64, 202, 270, 372, 370, 131, 276, 343, 431, 81, 249, 350, 104, 361, 390, 331, 369, 254, 14, 442, 284, 401, 400, 351, 84, 242, 203, 214, 93, 3, 89, 72, 223, 110, 208, 105, 12, 52, 265, 179, 80, 86, 246, 195, 438, 198, 245, 251, 61, 311, 469, 219, 328, 145, 371, 404, 338, 228, 366, 309, 420, 271, 453, 395, 48, 67, 69, 4, 399, 435, 127, 425, 264, 45, 55, 376, 123, 54, 220, 403, 432, 161, 261, 137, 8, 40, 423, 337, 53, 422, 146, 38, 457, 255, 433, 378, 449, 320, 88, 312, 139, 156, 295, 260, 164, 349, 23, 58, 464, 426, 117, 273, 162, 186, 135, 447, 446, 387, 348, 392, 158, 79, 322, 196, 160, 346, 323, 362, 82, 90, 253, 286, 85, 49, 472, 278, 141, 374, 358, 129, 18, 126, 150, 299, 339, 142, 298, 269, 274, 46, 352, 51, 439, 34, 237, 396, 235, 185, 393, 191, 211, 383, 115, 224, 289, 106, 101, 216, 33, 207, 347, 20, 76, 421, 170, 363, 188, 310, 332, 302, 316, 201, 325, 189, 379, 73, 397, 152, 468, 96, 418, 303, 236, 443, 100, 68, 60, 470, 305, 345, 37, 252, 445, 409, 277, 405, 391, 292, 19, 36, 314, 424, 119, 167, 257, 304, 95, 206, 181, 319, 62, 293, 429, 451, 287, 35, 467, 353, 441, 97, 178, 463, 212, 336, 147, 132, 288, 136, 239, 77, 57, 414, 280, 266, 315, 210, 267, 50, 21, 244, 415, 386, 229, 157, 243, 398, 232, 130, 215, 138, 344, 218, 124, 402, 15, 341, 107, 92, 17, 103, 153, 227, 417, 385, 411, 416, 75, 234, 380, 43, 450, 1, 112, 151, 155, 66, 204, 367, 437, 342, 333, 466, 47, 71, 199, 16, 182, 140, 294, 59, 436, 225, 460, 113, 5
        )
    ));
  }

  public int repeatedNumber(final List<Integer> A) {
    HashMap<Integer, Integer> countInRange = new HashMap<>();
    int sqrtN = (int) Math.sqrt(A.size());
    int buckets = A.size()/sqrtN;
    buckets = (A.size() % sqrtN == 0) ? buckets : buckets + 1;
    int repetitionKey = -1;
    for (int i=0; i<A.size(); i++) {
      int key = A.get(i) / sqrtN;
      if (!countInRange.containsKey(key)) {
        countInRange.put(key, 0);
      }

      countInRange.put(key, countInRange.get(key) + 1);
      if (A.get(i) == 17) {
        if (countInRange.get(key) > sqrtN
            || (key == buckets-1 && countInRange.get(key) > A.size() - (buckets-1) * sqrtN)) {
          repetitionKey = key;
          break;
        }
      }
      if (countInRange.get(key) > sqrtN
          || (key == buckets-1 && countInRange.get(key) > A.size() - (buckets-1) * sqrtN)) {
        repetitionKey = key;
        break;
      }
    }

    HashMap<Integer, Integer> countMap = new HashMap<>();
    for (int i=0; i<A.size(); i++) {
      if ((A.get(i) / sqrtN) == repetitionKey) {
        if (countMap.containsKey(A.get(i))) {
          return A.get(i);
        } else {
          countMap.put(A.get(i), 1);
        }
      }
    }

    return -1;
  }
}
