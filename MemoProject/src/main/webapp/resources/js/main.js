document.addEventListener('DOMContentLoaded', function () {

  // -------------------------------
  // 로그아웃 버튼 클릭 이벤트
  // -------------------------------
  const logout = document.querySelector("#logout");
  logout.addEventListener("click", () => {
    if (!confirm("정말 로그아웃하시겠습니까?")) return;
    location.href = "/logout"; // 로그아웃 요청
  });

  // -------------------------------
  // 브라우저 뒤로가기 방지 (히스토리 조작)
  // -------------------------------
  window.addEventListener("popstate", function (event) {
    history.pushState(null, "", location.href);
  });

  // -------------------------------
  // 메모 1열 / 2열 토글 버튼 기능
  // -------------------------------
  const inputs = document.querySelectorAll('.toggle-input input');
  const bar = document.querySelector('.toggle-bar');
  const leftIcon = document.querySelector('.toggle.left');
  const rightIcon = document.querySelector('.toggle.right');
  const container = document.querySelector('#container');

  inputs.forEach(input => {
    input.addEventListener('change', () => {
      const memoItems = document.querySelectorAll('.memo.item');
      if (input.value === 'col') {
        // 1열 모드
        bar.style.left = '0%';
        leftIcon.src = '/resources/img/sort-c-f.png'; // 왼쪽 아이콘 활성
        rightIcon.src = '/resources/img/sort-r.png'; // 오른쪽 아이콘 비활성

        container.style.flexDirection = 'row';
        container.style.flexWrap = 'wrap';

        memoItems.forEach(item => {
          item.style.width = '100%'; // 한 줄에 하나
        });

      } else {
        // 2열 모드
        bar.style.left = '50%';
        leftIcon.src = '/resources/img/sort-c.png'; // 왼쪽 아이콘 비활성
        rightIcon.src = '/resources/img/sort-r-f.png'; // 오른쪽 아이콘 활성

        container.style.flexDirection = 'row';
        container.style.flexWrap = 'wrap';

        memoItems.forEach(item => {
          item.style.width = 'calc(50% - 20px)'; // 한 줄에 두개씩
        });
      }
    });
  });

  // -------------------------------
  // 메모 정렬 (최신순 / 오래된순)
  // -------------------------------

  const orderSelect = document.querySelector("#orderSelect");
  const originalMemoItems = Array.from(document.querySelectorAll(".memo.item")); 
  // 원본 메모 리스트를 저장 (처음 로딩 순서 고정)

  orderSelect.addEventListener("change", () => {
    let sortedItems = [...originalMemoItems]; // 항상 원본 복사로 새로 시작

    if (orderSelect.value === 'asc') {
      sortedItems.reverse(); // 오래된 순이면 역순 정렬
    }

    container.innerHTML = ''; // 기존 메모 삭제

    sortedItems.forEach(item => container.appendChild(item)); // 정렬된 순서대로 다시 추가
  });

  // -------------------------------
  // 메모 검색 (내용 포함 검색)
  // -------------------------------

  const searchInput = document.querySelector("#searchInput");

  searchInput.addEventListener("input", () => {
    const value = searchInput.value.trim().toLowerCase();
    const memoItems = document.querySelectorAll(".memo.item");

    if (value.length === 0) {
      // 검색창이 비어있으면 모든 메모 다시 보이기
      memoItems.forEach(item => {
        item.style.display = "flex"; 
      });
    } else {
      memoItems.forEach(item => {
        const contentText = item.querySelector(".memo.content > p").textContent.toLowerCase();
        if (contentText.includes(value)) {
          item.style.display = "flex"; // 검색어가 포함되면 보이기
        } else {
          item.style.display = "none"; // 포함 안 되면 숨기기
        }
      });
    }
  });

});
