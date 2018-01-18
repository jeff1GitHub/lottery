function loginOrExit() {
	if(isLogin){
		$('#loginOrExit').val('登陆').button("refresh");;
	}else{
		$("#openLoginPage").trigger("click");  
	}
}

function login() {
	var account = $('#account').val();
	var pwd = $.md5($('#pwd').val());
	$.ajax({
		url: domain + '/lottery/user/login',
		type: 'POST',
		dataType: 'json',
		async: true,
		data: {
			'account': account,
			'pwd': pwd
		},
		success: function (result) {
			if(result.code == 200){
				isLogin = true;
				userName = result.data.name;
				token = result.data.token;
				$('#welcomeSpan').html('您好，' + userName);
				$('#loginOrExit').val('退出').button("refresh");;
				$('#loginPage').dialog('close');
			}else{
				alert(result.message);
			}
		},
		error: function (request, error) {
			alert('无法连接网络或者返回值错误!');
		}
	});
}

function getBeforPeriod() {
	$.ajax({
		url: domain + '/lottery/period/beforPeriod',
		dataType: 'json',
		async: true,
		success: function (result) {
			if(result.code == 200){
				if(result.data){
					$('#beforCode').html(result.data.code);
					
					if(result.data.result){
						var resultArr = result.data.result.split(',');
						$('#round1').html(resultArr[0]);
						$('#round2').html(resultArr[1]);
						$('#round3').html(resultArr[2]);
						$('#round4').html(resultArr[3]);
						$('#round5').html(resultArr[4]);
					}
				}
			}else{
				alert(result.message);
			}
		},
		error: function (request, error) {
			alert('无法连接网络或者返回值错误!');
		}
	});
}

function getNowPeriod() {
	$.ajax({
		url: domain + '/lottery/period/nowPeriod',
		dataType: 'json',
		async: true,
		success: function (result) {
			if(result.code == 200){
				if(result.data){
					$('#nowCode').html(result.data.code);
					
					if(result.data.status == 0){
						nowLotteryId = result.data.gameId;
						nowPeriodCode = result.data.code;
						var endTime = result.data.endTime;
						var finishTime = result.data.finishTime;
						var periodTimer = setInterval(function(){
							if(endTime > 0){
								var endS = parseInt(endTime / 60);
								if(endS < 10){
									endS = '0' + endS;
								}
								
								var endM = endTime % 60;
								if(endM < 10){
									endM = '0' + endM;
								}
								
								$('#endTimeSpan').html(endS + ":" + endM);
								endTime -= 1;
							}else{
								$('#endTimeSpan').html('已封盘');
							}
							
							if(finishTime > 0){
								var endS = parseInt(finishTime / 60);
								if(endS < 10){
									endS = '0' + endS;
								}
								
								var endM = finishTime % 60;
								if(endM < 10){
									endM = '0' + endM;
								}
								
								$('#finishTimeSpan').html(endS + ":" + endM);
								finishTime -= 1;
							}else{
								clearInterval(periodTimer);
								getBeforPeriod();
								getNowPeriod();
							}
						}, 1000);
					}
				}
			}else{
				alert(result.message);
			}
		},
		error: function (request, error) {
			alert('无法连接网络或者返回值错误!');
		}
	});
}

function showRightDiv(showName) {
	if('rightOneDiv' == showName){
		$('#rightOneDiv').css("display", "block");
	}else{
		$('#rightOneDiv').css("display", "none");
	}
	
	if('rightTwoDiv' == showName){
		$('#rightTwoDiv').css("display", "block");
	}else{
		$('#rightTwoDiv').css("display", "none");
	}
	
	if('rightThreeDiv' == showName){
		$('#rightThreeDiv').css("display", "block");
	}else{
		$('#rightThreeDiv').css("display", "none");
	}
}

function selectBetItem(selectedBets, item) {
	var itemId = item.id;
	for(var i=selectedBets.length-1; i>=0; --i){
		if(selectedBets[i][0] == itemId){
			selectedBets.splice(i, 1);
			$(item).removeClass('seletedBet');
			return;
		}
	}
	
	var odds = $(item).find('.odds').html();
	selectedBets[selectedBets.length] = [item.id, odds];
	$(item).addClass('seletedBet');
}

function cancelSeletedBet() {
	$('.seletedBet').removeClass('seletedBet');
	betItem = [];
	$('#selectedCount').html(betItem.length);
	$('#moneyInput').val(null);
}

function commitBet() {
	var money = $('#moneyInput').val();
	if(betItem && betItem.length > 0){
		var json = [];
        var obj = {};
		for(var index in betItem){
			obj.id = betItem[index][0];
			obj.odds = betItem[index][1];
			json.push(obj);
		}
		
		$.ajax({
			url: domain + '/lottery/betting/betting',
			type: 'POST',
			dataType: 'json',
			async: true,
			data: {
				'lotteryId': nowLotteryId,
				'periodCode': nowPeriodCode,
				'money': money,
				'projects': JSON.stringify(json)
			},
			success: function (result) {
				if(result.code == 200){
					cancelSeletedBet();
					alert(result.message);
				}else{
					alert(result.message);
				}
			},
			error: function (request, error) {
				alert('无法连接网络或者返回值错误!');
			}
		});
	}
}
