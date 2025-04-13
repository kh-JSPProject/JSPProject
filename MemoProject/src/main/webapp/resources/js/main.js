document.addEventListener('DOMContentLoaded', function () {

  const logout = document.querySelector("#logout");
  logout.addEventListener("click", () => {
    if (!confirm("정말 로그아웃하시겠습니까?")) return;
    location.href = "/logout";
  });

  window.addEventListener("popstate", function (event) {
    history.pushState(null, "", location.href);
  });

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
        leftIcon.src = '/resources/img/sort-c-f.png';
        rightIcon.src = '/resources/img/sort-r.png';

        container.style.flexDirection = 'row'; // 그대로 row
        container.style.flexWrap = 'wrap'; // 그대로 wrap

        memoItems.forEach(item => {
          item.style.width = '100%'; // 1열이니까 100% 채우기
        });

      } else {
        // 2열 모드
        bar.style.left = '50%';
        leftIcon.src = '/resources/img/sort-c.png';
        rightIcon.src = '/resources/img/sort-r-f.png';

        container.style.flexDirection = 'row'; // 그대로 row
        container.style.flexWrap = 'wrap'; // 그대로 wrap

        memoItems.forEach(item => {
          item.style.width = 'calc(50% - 20px)'; // 두 개씩 정렬
        });
      }
    });
  });

  const orderSelect = document.querySelector("#orderSelect");

  orderSelect.addEventListener("change", () => {
    const container = document.querySelector("#container");
    const memoItems = Array.from(document.querySelectorAll(".memo.item"));

    // 기존 메모들 제거
    memoItems.forEach(item => container.removeChild(item));

    // asc(오래된순)이면 역순으로
    if (orderSelect.value === 'asc') {
      memoItems.reverse();
    }

    // 다시 container에 추가
    memoItems.forEach(item => container.appendChild(item));
  });

  const searchInput = document.querySelector("#searchInput");

  searchInput.addEventListener("input", () => {
    const value = searchInput.value.trim().toLowerCase();
    const memoItems = document.querySelectorAll(".memo.item");

    if (value.length === 0) {
      // 검색창이 비어있으면 모든 메모 다시 보이게
      memoItems.forEach(item => {
        item.style.display = "flex"; // 원래 flex였지
      });
    } else {
      memoItems.forEach(item => {
        const contentText = item.querySelector(".memo.content > p").textContent.toLowerCase();
        if (contentText.includes(value)) {
          item.style.display = "flex";
        } else {
          item.style.display = "none";
        }
      });
    }
  });

});
