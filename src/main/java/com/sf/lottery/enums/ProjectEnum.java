package com.sf.lottery.enums;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.sf.lottery.entity.Betting;
import com.sf.lottery.entity.BettingSquareInfo;

/**
 * 投注项枚举
 */
public enum ProjectEnum {
	/** 总和大 */
	SUM_BIG(1),
	/** 总和小 */
	SUM_SMALL(2),
	/** 总和单 */
	SUM_SINGLE(3),
	/** 总和双 */
	SUM_DOUBLE(4),
	/** 龙 */
	LOONG(5),
	/** 虎 */
	TIGER(6),
	/** 和 */
	TIE(7),

	/** 第一球大 */
	FIRST_BIG(8),
	/** 第一球小 */
	FIRST_SMALL(9),
	/** 第一球单 */
	FIRST_SINGLE(10),
	/** 第一球双 */
	FIRST_DOUNLE(11),

	/** 第二球大 */
	SECOND_BIG(12),
	/** 第二球小 */
	SECOND_SMALL(13),
	/** 第二球单 */
	SECOND_SINGLE(14),
	/** 第二球双 */
	SECOND_DOUBLE(15),

	/** 第三球大 */
	THIRD_BIG(16),
	/** 第三球小 */
	THIRD_SMALL(17),
	/** 第三球单 */
	THIRD_SINGLE(18),
	/** 第三球双 */
	THIRD_DOUBLE(19),

	/** 第四球大 */
	FOURTH_BIG(20),
	/** 第四球小 */
	FOURTH_SMALL(21),
	/** 第四球单 */
	FOURTH_SINGLE(22),
	/** 第四球双 */
	FOURTH_DOUBLE(23),

	/** 第五球大 */
	FIFTH_BIG(24),
	/** 第五球小 */
	FIFTH_SMALL(25),
	/** 第五球单 */
	FIFTH_SINGLE(26),
	/** 第五球双 */
	FIFTH_DOUBLE(27),

	/** 总和尾数0 */
	SUM_LAST_NUM_0(28),
	/** 总和尾数1 */
	SUM_LAST_NUM_1(29),
	/** 总和尾数2 */
	SUM_LAST_NUM_2(30),
	/** 总和尾数3 */
	SUM_LAST_NUM_3(31),
	/** 总和尾数4 */
	SUM_LAST_NUM_4(32),
	/** 总和尾数5 */
	SUM_LAST_NUM_5(33),
	/** 总和尾数6 */
	SUM_LAST_NUM_6(34),
	/** 总和尾数7 */
	SUM_LAST_NUM_7(35),
	/** 总和尾数8 */
	SUM_LAST_NUM_8(36),
	/** 总和尾数9 */
	SUM_LAST_NUM_9(37),

	/** 第一球0 */
	FIRST_NUM_0(38),
	/** 第一球1 */
	FIRST_NUM_1(39),
	/** 第一球2 */
	FIRST_NUM_2(40),
	/** 第一球3 */
	FIRST_NUM_3(41),
	/** 第一球4 */
	FIRST_NUM_4(42),
	/** 第一球5 */
	FIRST_NUM_5(43),
	/** 第一球6 */
	FIRST_NUM_6(44),
	/** 第一球7 */
	FIRST_NUM_7(45),
	/** 第一球8 */
	FIRST_NUM_8(46),
	/** 第一球9 */
	FIRST_NUM_9(47),

	/** 第二球0 */
	SECOND_NUM_0(48),
	/** 第二球1 */
	SECOND_NUM_1(49),
	/** 第二球2 */
	SECOND_NUM_2(50),
	/** 第二球3 */
	SECOND_NUM_3(51),
	/** 第二球4 */
	SECOND_NUM_4(52),
	/** 第二球5 */
	SECOND_NUM_5(53),
	/** 第二球6 */
	SECOND_NUM_6(54),
	/** 第二球7 */
	SECOND_NUM_7(55),
	/** 第二球8 */
	SECOND_NUM_8(56),
	/** 第二球9 */
	SECOND_NUM_9(57),

	/** 第三球0 */
	THIRD_NUM_0(58),
	/** 第三球1 */
	THIRD_NUM_1(59),
	/** 第三球2 */
	THIRD_NUM_2(60),
	/** 第三球3 */
	THIRD_NUM_3(61),
	/** 第三球4 */
	THIRD_NUM_4(62),
	/** 第三球5 */
	THIRD_NUM_5(63),
	/** 第三球6 */
	THIRD_NUM_6(64),
	/** 第三球7 */
	THIRD_NUM_7(65),
	/** 第三球8 */
	THIRD_NUM_8(66),
	/** 第三球9 */
	THIRD_NUM_9(67),

	/** 第四球0 */
	FOURTH_NUM_0(68),
	/** 第四球1 */
	FOURTH_NUM_1(69),
	/** 第四球2 */
	FOURTH_NUM_2(70),
	/** 第四球3 */
	FOURTH_NUM_3(71),
	/** 第四球4 */
	FOURTH_NUM_4(72),
	/** 第四球5 */
	FOURTH_NUM_5(73),
	/** 第四球6 */
	FOURTH_NUM_6(74),
	/** 第四球7 */
	FOURTH_NUM_7(75),
	/** 第四球8 */
	FOURTH_NUM_8(76),
	/** 第四球9 */
	FOURTH_NUM_9(77),

	/** 第五球0 */
	FIFTH_NUM_0(78),
	/** 第五球1 */
	FIFTH_NUM_1(79),
	/** 第五球2 */
	FIFTH_NUM_2(80),
	/** 第五球3 */
	FIFTH_NUM_3(81),
	/** 第五球4 */
	FIFTH_NUM_4(82),
	/** 第五球5 */
	FIFTH_NUM_5(83),
	/** 第五球6 */
	FIFTH_NUM_6(84),
	/** 第五球7 */
	FIFTH_NUM_7(85),
	/** 第五球8 */
	FIFTH_NUM_8(86),
	/** 第五球9 */
	FIFTH_NUM_9(87),

	/** 前三豹子 */
	BEFOR_THREE_SAME(88),
	/** 中三豹子 */
	MIDLLE_THREE_SAME(89),
	/** 后三豹子 */
	LAST_THREE_SAME(90);
	
	private final int id;
	
	private ProjectEnum(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}

	public static ProjectEnum valueOf(int id) {
		for(ProjectEnum e : ProjectEnum.values()){
			if(e.getId() == id){
				return e;
			}
		}
		return null;
	}
	
	public static BettingSquareInfo square(Betting betting, int[] result, boolean isSumBig, boolean isSumSingle, int sumLastNum,
			boolean isBeforThreeSame, boolean isMidlleThreeSame, boolean isLastThreeSame) {
		ProjectEnum pe = ProjectEnum.valueOf(betting.getProject());
		BigDecimal squareResult;
		switch (pe) {
			case SUM_BIG:
				squareResult = isSumBig ? betting.getMoney().multiply(betting.getOdds()) : null;
				break;
			case SUM_SMALL:
				squareResult = isSumBig ? null : betting.getMoney().multiply(betting.getOdds());
				break;
			case SUM_SINGLE:
				squareResult = isSumSingle ? betting.getMoney().multiply(betting.getOdds()) : null;
				break;
			case SUM_DOUBLE:
				squareResult = isSumSingle ? null : betting.getMoney().multiply(betting.getOdds());
				break;
			case LOONG:
				squareResult = result[0] > result[4] ? betting.getMoney().multiply(betting.getOdds()) : null;
				break;
			case TIGER:
				squareResult = result[0] < result[4] ? betting.getMoney().multiply(betting.getOdds()) : null;
				break;
			case TIE:
				squareResult = result[0] == result[4] ? betting.getMoney().multiply(betting.getOdds()) : null;
				break;

			case FIRST_BIG:
				squareResult = result[0] >= 5 ? betting.getMoney().multiply(betting.getOdds()) : null;
				break;
			case FIRST_SMALL:
				squareResult = result[0] < 5 ? betting.getMoney().multiply(betting.getOdds()) : null;
				break;
			case FIRST_SINGLE:
				squareResult = result[0] % 2 == 1 ? betting.getMoney().multiply(betting.getOdds()) : null;
				break;
			case FIRST_DOUNLE:
				squareResult = result[0] % 2 == 0 ? betting.getMoney().multiply(betting.getOdds()) : null;
				break;

			case SECOND_BIG:
				squareResult = result[1] >= 5 ? betting.getMoney().multiply(betting.getOdds()) : null;
				break;
			case SECOND_SMALL:
				squareResult = result[1] < 5 ? betting.getMoney().multiply(betting.getOdds()) : null;
				break;
			case SECOND_SINGLE:
				squareResult = result[1] % 2 == 1 ? betting.getMoney().multiply(betting.getOdds()) : null;
				break;
			case SECOND_DOUBLE:
				squareResult = result[1] % 2 == 0 ? betting.getMoney().multiply(betting.getOdds()) : null;
				break;

			case THIRD_BIG:
				squareResult = result[2] >= 5 ? betting.getMoney().multiply(betting.getOdds()) : null;
				break;
			case THIRD_SMALL:
				squareResult = result[2] < 5 ? betting.getMoney().multiply(betting.getOdds()) : null;
				break;
			case THIRD_SINGLE:
				squareResult = result[2] % 2 == 1 ? betting.getMoney().multiply(betting.getOdds()) : null;
				break;
			case THIRD_DOUBLE:
				squareResult = result[2] % 2 == 0 ? betting.getMoney().multiply(betting.getOdds()) : null;
				break;

			case FOURTH_BIG:
				squareResult = result[3] >= 5 ? betting.getMoney().multiply(betting.getOdds()) : null;
				break;
			case FOURTH_SMALL:
				squareResult = result[3] < 5 ? betting.getMoney().multiply(betting.getOdds()) : null;
				break;
			case FOURTH_SINGLE:
				squareResult = result[3] % 2 == 1 ? betting.getMoney().multiply(betting.getOdds()) : null;
				break;
			case FOURTH_DOUBLE:
				squareResult = result[3] % 2 == 0 ? betting.getMoney().multiply(betting.getOdds()) : null;
				break;

			case FIFTH_BIG:
				squareResult = result[4] >= 5 ? betting.getMoney().multiply(betting.getOdds()) : null;
				break;
			case FIFTH_SMALL:
				squareResult = result[4] < 5 ? betting.getMoney().multiply(betting.getOdds()) : null;
				break;
			case FIFTH_SINGLE:
				squareResult = result[4] % 2 == 1 ? betting.getMoney().multiply(betting.getOdds()) : null;
				break;
			case FIFTH_DOUBLE:
				squareResult = result[4] % 2 == 0 ? betting.getMoney().multiply(betting.getOdds()) : null;
				break;

			case SUM_LAST_NUM_0:
				squareResult = sumLastNum == 0 ? betting.getMoney().multiply(betting.getOdds()) : null;
				break;
			case SUM_LAST_NUM_1:
				squareResult = sumLastNum == 1 ? betting.getMoney().multiply(betting.getOdds()) : null;
				break;
			case SUM_LAST_NUM_2:
				squareResult = sumLastNum == 2 ? betting.getMoney().multiply(betting.getOdds()) : null;
				break;
			case SUM_LAST_NUM_3:
				squareResult = sumLastNum == 3 ? betting.getMoney().multiply(betting.getOdds()) : null;
				break;
			case SUM_LAST_NUM_4:
				squareResult = sumLastNum == 4 ? betting.getMoney().multiply(betting.getOdds()) : null;
				break;
			case SUM_LAST_NUM_5:
				squareResult = sumLastNum == 5 ? betting.getMoney().multiply(betting.getOdds()) : null;
				break;
			case SUM_LAST_NUM_6:
				squareResult = sumLastNum == 6 ? betting.getMoney().multiply(betting.getOdds()) : null;
				break;
			case SUM_LAST_NUM_7:
				squareResult = sumLastNum == 7 ? betting.getMoney().multiply(betting.getOdds()) : null;
				break;
			case SUM_LAST_NUM_8:
				squareResult = sumLastNum == 8 ? betting.getMoney().multiply(betting.getOdds()) : null;
				break;
			case SUM_LAST_NUM_9:
				squareResult = sumLastNum == 9 ? betting.getMoney().multiply(betting.getOdds()) : null;
				break;

			case FIRST_NUM_0:
				squareResult = result[0] == 0 ? betting.getMoney().multiply(betting.getOdds()) : null;
				break;
			case FIRST_NUM_1:
				squareResult = result[0] == 1 ? betting.getMoney().multiply(betting.getOdds()) : null;
				break;
			case FIRST_NUM_2:
				squareResult = result[0] == 2 ? betting.getMoney().multiply(betting.getOdds()) : null;
				break;
			case FIRST_NUM_3:
				squareResult = result[0] == 3 ? betting.getMoney().multiply(betting.getOdds()) : null;
				break;
			case FIRST_NUM_4:
				squareResult = result[0] == 4 ? betting.getMoney().multiply(betting.getOdds()) : null;
				break;
			case FIRST_NUM_5:
				squareResult = result[0] == 5 ? betting.getMoney().multiply(betting.getOdds()) : null;
				break;
			case FIRST_NUM_6:
				squareResult = result[0] == 6 ? betting.getMoney().multiply(betting.getOdds()) : null;
				break;
			case FIRST_NUM_7:
				squareResult = result[0] == 7 ? betting.getMoney().multiply(betting.getOdds()) : null;
				break;
			case FIRST_NUM_8:
				squareResult = result[0] == 8 ? betting.getMoney().multiply(betting.getOdds()) : null;
				break;
			case FIRST_NUM_9:
				squareResult = result[0] == 9 ? betting.getMoney().multiply(betting.getOdds()) : null;
				break;

			case SECOND_NUM_0:
				squareResult = result[1] == 0 ? betting.getMoney().multiply(betting.getOdds()) : null;
				break;
			case SECOND_NUM_1:
				squareResult = result[1] == 1 ? betting.getMoney().multiply(betting.getOdds()) : null;
				break;
			case SECOND_NUM_2:
				squareResult = result[1] == 2? betting.getMoney().multiply(betting.getOdds()) : null;
				break;
			case SECOND_NUM_3:
				squareResult = result[1] == 3 ? betting.getMoney().multiply(betting.getOdds()) : null;
				break;
			case SECOND_NUM_4:
				squareResult = result[1] == 4 ? betting.getMoney().multiply(betting.getOdds()) : null;
				break;
			case SECOND_NUM_5:
				squareResult = result[1] == 5 ? betting.getMoney().multiply(betting.getOdds()) : null;
				break;
			case SECOND_NUM_6:
				squareResult = result[1] == 6 ? betting.getMoney().multiply(betting.getOdds()) : null;
				break;
			case SECOND_NUM_7:
				squareResult = result[1] == 7 ? betting.getMoney().multiply(betting.getOdds()) : null;
				break;
			case SECOND_NUM_8:
				squareResult = result[1] == 8 ? betting.getMoney().multiply(betting.getOdds()) : null;
				break;
			case SECOND_NUM_9:
				squareResult = result[1] == 9 ? betting.getMoney().multiply(betting.getOdds()) : null;
				break;

			case THIRD_NUM_0:
				squareResult = result[2] == 0 ? betting.getMoney().multiply(betting.getOdds()) : null;
				break;
			case THIRD_NUM_1:
				squareResult = result[2] == 1 ? betting.getMoney().multiply(betting.getOdds()) : null;
				break;
			case THIRD_NUM_2:
				squareResult = result[2] == 2 ? betting.getMoney().multiply(betting.getOdds()) : null;
				break;
			case THIRD_NUM_3:
				squareResult = result[2] == 3 ? betting.getMoney().multiply(betting.getOdds()) : null;
				break;
			case THIRD_NUM_4:
				squareResult = result[2] == 4 ? betting.getMoney().multiply(betting.getOdds()) : null;
				break;
			case THIRD_NUM_5:
				squareResult = result[2] == 5 ? betting.getMoney().multiply(betting.getOdds()) : null;
				break;
			case THIRD_NUM_6:
				squareResult = result[2] == 6 ? betting.getMoney().multiply(betting.getOdds()) : null;
				break;
			case THIRD_NUM_7:
				squareResult = result[2] == 7 ? betting.getMoney().multiply(betting.getOdds()) : null;
				break;
			case THIRD_NUM_8:
				squareResult = result[2] == 8 ? betting.getMoney().multiply(betting.getOdds()) : null;
				break;
			case THIRD_NUM_9:
				squareResult = result[2] == 9 ? betting.getMoney().multiply(betting.getOdds()) : null;
				break;

			case FOURTH_NUM_0:
				squareResult = result[3] == 0 ? betting.getMoney().multiply(betting.getOdds()) : null;
				break;
			case FOURTH_NUM_1:
				squareResult = result[3] == 1 ? betting.getMoney().multiply(betting.getOdds()) : null;
				break;
			case FOURTH_NUM_2:
				squareResult = result[3] == 2 ? betting.getMoney().multiply(betting.getOdds()) : null;
				break;
			case FOURTH_NUM_3:
				squareResult = result[3] == 3 ? betting.getMoney().multiply(betting.getOdds()) : null;
				break;
			case FOURTH_NUM_4:
				squareResult = result[3] == 4 ? betting.getMoney().multiply(betting.getOdds()) : null;
				break;
			case FOURTH_NUM_5:
				squareResult = result[3] == 5 ? betting.getMoney().multiply(betting.getOdds()) : null;
				break;
			case FOURTH_NUM_6:
				squareResult = result[3] == 6 ? betting.getMoney().multiply(betting.getOdds()) : null;
				break;
			case FOURTH_NUM_7:
				squareResult = result[3] == 7 ? betting.getMoney().multiply(betting.getOdds()) : null;
				break;
			case FOURTH_NUM_8:
				squareResult = result[3] == 8 ? betting.getMoney().multiply(betting.getOdds()) : null;
				break;
			case FOURTH_NUM_9:
				squareResult = result[3] == 9 ? betting.getMoney().multiply(betting.getOdds()) : null;
				break;

			case FIFTH_NUM_0:
				squareResult = result[4] == 0 ? betting.getMoney().multiply(betting.getOdds()) : null;
				break;
			case FIFTH_NUM_1:
				squareResult = result[4] == 1 ? betting.getMoney().multiply(betting.getOdds()) : null;
				break;
			case FIFTH_NUM_2:
				squareResult = result[4] == 2 ? betting.getMoney().multiply(betting.getOdds()) : null;
				break;
			case FIFTH_NUM_3:
				squareResult = result[4] == 3 ? betting.getMoney().multiply(betting.getOdds()) : null;
				break;
			case FIFTH_NUM_4:
				squareResult = result[4] == 4 ? betting.getMoney().multiply(betting.getOdds()) : null;
				break;
			case FIFTH_NUM_5:
				squareResult = result[4] == 5 ? betting.getMoney().multiply(betting.getOdds()) : null;
				break;
			case FIFTH_NUM_6:
				squareResult = result[4] == 6 ? betting.getMoney().multiply(betting.getOdds()) : null;
				break;
			case FIFTH_NUM_7:
				squareResult = result[4] == 7 ? betting.getMoney().multiply(betting.getOdds()) : null;
				break;
			case FIFTH_NUM_8:
				squareResult = result[4] == 8 ? betting.getMoney().multiply(betting.getOdds()) : null;
				break;
			case FIFTH_NUM_9:
				squareResult = result[4] == 9 ? betting.getMoney().multiply(betting.getOdds()) : null;
				break;

			case BEFOR_THREE_SAME:
				squareResult = isBeforThreeSame ? betting.getMoney().multiply(betting.getOdds()) : null;
				break;
			case MIDLLE_THREE_SAME:
				squareResult = isMidlleThreeSame ? betting.getMoney().multiply(betting.getOdds()) : null;
				break;
			case LAST_THREE_SAME:
				squareResult = isLastThreeSame ? betting.getMoney().multiply(betting.getOdds()) : null;
				break;
			default: return null;
		}
		
		if(squareResult == null){
			squareResult = betting.getMoney();
		}else{
			squareResult = new BigDecimal(0).subtract(squareResult);
		}
		
		BettingSquareInfo squareInfo = new BettingSquareInfo(betting.getId(), squareResult, LocalDateTime.now());
		return squareInfo;
	}
	
}
