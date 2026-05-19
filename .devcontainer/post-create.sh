#!/usr/bin/env bash
set -e

chmod +x mvnw
git lfs version

make env
./mvnw -q -DskipTests dependency:go-offline

if ! grep -q "PayTrack custom prompt" ~/.bashrc; then
  cat <<'EOF' >> ~/.bashrc

# PayTrack custom prompt: ~/project (branch) $
git_branch() {
  local branch
  branch=$(git branch --show-current 2>/dev/null)

  if [ -n "$branch" ]; then
    echo " ($branch)"
  fi
}

short_pwd() {
  echo "~/${PWD##*/}"
}

export PS1='\[\033[01;34m\]$(short_pwd)\[\033[00m\]\[\033[01;31m\]$(git_branch)\[\033[00m\] \$ '
EOF
fi